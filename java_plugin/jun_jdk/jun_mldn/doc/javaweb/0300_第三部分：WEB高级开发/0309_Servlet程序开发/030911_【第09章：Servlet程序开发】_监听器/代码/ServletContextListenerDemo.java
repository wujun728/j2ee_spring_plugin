package org.lxh.listenerdemo ;
import javax.servlet.* ;
public class ServletContextListenerDemo implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event){
		System.out.println("** ������ʼ�� --> " + event.getServletContext().getContextPath()) ;
	}
	public void contextDestroyed(ServletContextEvent event){
		System.out.println("** �������� --> " + event.getServletContext().getContextPath()) ;
		try{
			Thread.sleep(300) ;
		}catch(Exception e){}
	}
}
/*
	<listener>
		<listener-class>
			org.lxh.listenerdemo.ServletContextListenerDemo
		</listener-class>
	</listener>
*/