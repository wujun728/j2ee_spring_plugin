package org.myframework.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * ���SPRING ��BEAN��ȡ�� SPRING ������ˢ��
 * @author Administrator
 *
 */
public class SpringUtil {
	private static Log log = LogFactory.getLog(SpringUtil.class);
	
    /**
     * ȡ��SpringBeanʵ��
     * @param request
     * @param beanId
     * @return
     */
    public static Object getBean(HttpServletRequest request, String beanId) {
        return getWebApplicationContext(request).getBean(beanId);
    }

	/**
	 * ˢ��WEB��SPRING����Ϣ
	 * @param request
	 */
	public static void refreshSpring(HttpServletRequest request) {
		WebApplicationContext wac = getWebApplicationContext(request);
		refreshSpring(wac);
	}
	
	/**
	 * ˢ��SPRING����Ϣ
	 * @param aContext
	 */
	public static void refreshSpring(ApplicationContext aContext) {
		Class[] cls = ClassUtils.getAllInterfaces(aContext);
		for (Class item : cls) {
			if (ConfigurableApplicationContext.class.getName().equals(
					item.getName())) {
				log.debug("refresh   Spring start ");
				long start = System.currentTimeMillis();
				((ConfigurableApplicationContext) aContext).refresh();
				log.debug("refresh   Spring end ; cost time (ms) :"
						+ (System.currentTimeMillis() - start));
			}
		}
	}

	/**
	 * ȡ��WebApplicationContext
	 * @param sc
	 * @return
	 */
	public static WebApplicationContext getWebApplicationContext(
			ServletContext sc) {
		// ͨ��web.xml ���� org.springframework.web.context.ContextLoaderListener ���ء�
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc);
		if (ctx == null) {
				throw new RuntimeException(
						"WebApplicationContext error ........  Can't find [WebApplicationContext] in any scope !");
		}
		return ctx;
	}

	/**
	 * ȡ��WebApplicationContext
	 * @param request
	 * @return
	 */
	public static WebApplicationContext getWebApplicationContext(
			HttpServletRequest request) {
		ServletContext sc = request.getSession().getServletContext();
		return getWebApplicationContext(sc);
	}

}
