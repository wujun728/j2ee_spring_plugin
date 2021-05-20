package org.lxh.listenerdemo ;
import javax.servlet.* ;
public class ServletRequestAttributeListenerDemo implements ServletRequestAttributeListener {
	public void attributeAdded(ServletRequestAttributeEvent srae){
		System.out.println("** ����request���� --> �������ƣ�" + srae.getName() + "���������ݣ�" + srae.getValue()) ;
	}
	public void attributeRemoved(ServletRequestAttributeEvent srae){
		System.out.println("** ɾ��request���� --> �������ƣ�" + srae.getName() + "���������ݣ�" + srae.getValue()) ;
	}
	public void attributeReplaced(ServletRequestAttributeEvent srae){
		System.out.println("** �滻request���� --> �������ƣ�" + srae.getName() + "���������ݣ�" + srae.getValue()) ;
	}
}
/*
	<listener>
		<listener-class>
			org.lxh.listenerdemo.ServletRequestAttributeListenerDemo
		</listener-class>
	</listener>
*/