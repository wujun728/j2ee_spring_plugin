package org.lxh.listenerdemo ;
import javax.servlet.* ;
public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener {
	public void attributeAdded(ServletContextAttributeEvent scab){
		System.out.println("** �������� --> �������ƣ�" + scab.getName() + "���������ݣ�" + scab.getValue()) ;
	}
	public void attributeRemoved(ServletContextAttributeEvent scab){
		System.out.println("** ɾ������ --> �������ƣ�" + scab.getName() + "���������ݣ�" + scab.getValue()) ;
	}
	public void attributeReplaced(ServletContextAttributeEvent scab){
		System.out.println("** �滻���� --> �������ƣ�" + scab.getName() + "���������ݣ�" + scab.getValue()) ;
	}
}
/*
	<listener>
		<listener-class>
			org.lxh.listenerdemo.ServletContextAttributeListenerDemo
		</listener-class>
	</listener>
*/