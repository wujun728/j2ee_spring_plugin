package io.github.wujun728.common.base.run;

import cn.hutool.core.lang.Console;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.log.StaticLog;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.druid.DruidPlugin;
import io.github.wujun728.rest.util.DataSourcePool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import static io.github.wujun728.rest.util.DataSourcePool.main;

@Slf4j
@Order(1)
@Component
public class CommandLineRunnerDS implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        try {
            DataSource ds = SpringUtil.getBean(DataSource.class);
            if(ds == null){
                StaticLog.error("当前数据库未设置默认数据源，请设置默认数据源！！！");
            }else{
                DataSourcePool.add(main,ds);
                if(DbKit.getConfig(main) == null){
                    //Db.init(main, DataSourcePool.get(DbKit.MAIN_CONFIG_NAME));
                    //DruidPlugin dp = new DruidPlugin(url, username, password);
                    ActiveRecordPlugin arp = new ActiveRecordPlugin("main", ds);
                    arp.setDevMode(true);
                    arp.setShowSql(true);
                    //dp.start();
                    arp.start();
                    log.warn("Config have bean created by configName: {}","main");
                }
            }
        } catch (NoSuchBeanDefinitionException e) {
            StaticLog.error("Spring无内置DataSource数据源！");
            initDefaultDataSource();
            //throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
            StaticLog.error("DbCommandRun 数据源初始化失败！！！");
            initDefaultDataSource();
            //throw new RuntimeException(e);
        }
    }


    public DataSource initDefaultDataSource() {
        DataSource dataSource = null;
        if(dataSource == null){
            dataSource = initDefaultDataSourceV1();
            if(dataSource == null){
                Console.log("initDefaultDataSource 默认数据源为空，需要手动初始化DataSource end ");
            }
        }else {
            log.info("datasource autowried sucess init step1 ");
        }
        return dataSource;
    }

//    private static DataSource initActiveRecordPlusin() {
//        String url = SpringUtil.getProperty("project.datasource.url");
//        String username = SpringUtil.getProperty("project.datasource.username");
//        String password = SpringUtil.getProperty("project.datasource.password");
//        String driver = SpringUtil.getProperty("project.datasource.driver-class-name");
//        StaticLog.info("project.datasource.url"+"="+url);
//        StaticLog.info("project.datasource.username"+"="+username);
//        StaticLog.info("project.datasource.password"+"="+password);
//        StaticLog.info("project.datasource.driver-class-name"+"="+driver);
//        StaticLog.info("current datasource is master ");
//        DataSource masterDataSource = DataSourcePool.init("master",url,username,password,driver);
//        Db.initAlias("master",url,username, password);
////		DataSourcePool.initActiveRecordPlugin("master",masterDataSource);
//        return masterDataSource;
//    }

    public static DataSource initDefaultDataSourceV1() {
        String url = SpringUtil.getProperty("spring.datasource.url");
        String username = SpringUtil.getProperty("spring.datasource.username");
        String password = SpringUtil.getProperty("spring.datasource.password");
        String driver = SpringUtil.getProperty("spring.datasource.driver-class-name");
        Console.log("initDefaultDataSource info  spring.datasource.url:{}",url);
        StaticLog.info("spring.datasource.url"+"="+url);
        StaticLog.info("spring.datasource.username"+"="+username);
        StaticLog.info("spring.datasource.password"+"="+password);
        StaticLog.info("spring.datasource.driver-class-name"+"="+driver);
        StaticLog.info("current datasource is default ");
        if(!StringUtils.isEmpty(url)) {
            if(DbKit.getConfig(main) == null){
                //Db.initAlias(main,url,username, password);
                if(DbKit.getConfig(main) == null){
                    //Db.init(main, DataSourcePool.get(DbKit.MAIN_CONFIG_NAME));
                    DruidPlugin dp = new DruidPlugin(url, username, password);
                    ActiveRecordPlugin arp = new ActiveRecordPlugin(main, dp);
                    arp.setDevMode(true);
                    arp.setShowSql(true);
                    dp.start();
                    arp.start();
                    log.warn("Config have bean created by configName: {}",main);
                }
            }
            return DataSourcePool.init(main,url,username,password,driver);
        }else {
            return null;
        }
    }

//	public ActiveRecordPlugin initActiveRecordPlugin() {
//		DataSource dataSource = null;
//		if(dataSource == null){
//			dataSource = SpringUtil.getBean(DataSource.class);
//		}
//		if(dataSource != null){
//			return DataSourcePool.initActiveRecordPlugin("main",dataSource);
//		}else {
//			return null;
//		}
//	}
}
