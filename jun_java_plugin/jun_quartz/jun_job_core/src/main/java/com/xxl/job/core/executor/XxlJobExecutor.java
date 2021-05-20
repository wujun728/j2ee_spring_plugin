package com.xxl.job.core.executor;

import com.xxl.job.core.biz.ExecutorBiz;
import com.xxl.job.core.biz.impl.ExecutorBizImpl;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.registry.RegistHelper;
import com.xxl.job.core.rpc.netcom.NetComServerFactory;
import com.xxl.job.core.thread.ExecutorRegistryThread;
import com.xxl.job.core.thread.JobThread;
import com.xxl.job.core.thread.TriggerCallbackThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xuxueli on 2016/3/2 21:14.
 */
public class XxlJobExecutor implements ApplicationContextAware, ApplicationListener {
    private static final Logger logger = LoggerFactory.getLogger(XxlJobExecutor.class);

    private String ip;
    private int port = 9999;
    private String appName;
    private RegistHelper registHelper;

    public void setIp(String ip) {
        this.ip = ip;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }
    public void setRegistHelper(RegistHelper registHelper) {
        this.registHelper = registHelper;
    }

    // ---------------------------------- job server ------------------------------------
    private NetComServerFactory serverFactory = new NetComServerFactory();
    public void start() throws Exception {
        // executor start
        NetComServerFactory.putService(ExecutorBiz.class, new ExecutorBizImpl());
        serverFactory.start(port, ip, appName, registHelper);

        // trigger callback thread start
        TriggerCallbackThread.getInstance().start();
    }
    public void destroy(){
        // executor stop
        serverFactory.destroy();

        // job thread repository destory
        if (JobThreadRepository.size() > 0) {
            for (Map.Entry<Integer, JobThread> item: JobThreadRepository.entrySet()) {
                JobThread jobThread = item.getValue();
                jobThread.toStop("Web容器销毁终止");
                jobThread.interrupt();

            }
            JobThreadRepository.clear();
        }

        // trigger callback thread stop
        TriggerCallbackThread.getInstance().toStop();

        // executor registry thread stop
        ExecutorRegistryThread.getInstance().toStop();
    }

    // ---------------------------------- init job handler ------------------------------------
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        // init job handler action
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(JobHander.class);

        if (serviceBeanMap!=null && serviceBeanMap.size()>0) {
            for (Object serviceBean : serviceBeanMap.values()) {
                if (serviceBean instanceof IJobHandler){
                    String name = serviceBean.getClass().getAnnotation(JobHander.class).value();
                    IJobHandler handler = (IJobHandler) serviceBean;
                    registJobHandler(name, handler);
                }
            }
        }
	}

    // ---------------------------------- destory job executor ------------------------------------
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ContextClosedEvent){
            // TODO
        }
    }

    // ---------------------------------- job handler repository
    private static ConcurrentHashMap<String, IJobHandler> jobHandlerRepository = new ConcurrentHashMap<String, IJobHandler>();
    public static IJobHandler registJobHandler(String name, IJobHandler jobHandler){
        logger.info("xxl-job register jobhandler success, name:{}, jobHandler:{}", name, jobHandler);
        return jobHandlerRepository.put(name, jobHandler);
    }
    public static IJobHandler loadJobHandler(String name){
        return jobHandlerRepository.get(name);
    }

    // ---------------------------------- job thread repository
    private static ConcurrentHashMap<Integer, JobThread> JobThreadRepository = new ConcurrentHashMap<Integer, JobThread>();
    public static JobThread registJobThread(int jobId, IJobHandler handler){
        JobThread jobThread = new JobThread(handler);
        jobThread.start();
        logger.info(">>>>>>>>>>> xxl-job regist JobThread success, jobId:{}, handler:{}", new Object[]{jobId, handler});
        JobThreadRepository.put(jobId, jobThread);	// putIfAbsent | oh my god, map's put method return the old value!!!
        return jobThread;
    }
    public static JobThread loadJobThread(int jobId){
        JobThread jobThread = JobThreadRepository.get(jobId);
        return jobThread;
    }
    public static void removeJobThread(int jobId){
        JobThreadRepository.remove(jobId);
    }

}
