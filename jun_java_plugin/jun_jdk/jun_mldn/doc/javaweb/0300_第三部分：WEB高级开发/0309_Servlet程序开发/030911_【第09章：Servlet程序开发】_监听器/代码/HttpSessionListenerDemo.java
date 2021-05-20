package org.lxh.listenerdemo ;
import javax.servlet.http.* ;
public class HttpSessionListenerDemo implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent se){
		System.out.println("** SESSION������SESSION ID = " +se.getSession().getId() ) ;
	}
	public void sessionDestroyed(HttpSessionEvent se){
		System.out.println("** SESSION���٣�SESSION ID = " +se.getSession().getId() ) ;
	}
}
/*
	<listener>
		<listener-class>
			org.lxh.listenerdemo.HttpSessionListenerDemo
		</listener-class>
	</listener>
*/