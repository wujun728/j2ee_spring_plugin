package org.lxh.listenerdemo ;
import javax.servlet.http.* ;
public class HttpSessionAttributeListenerDemo implements HttpSessionAttributeListener {
	public void attributeAdded(HttpSessionBindingEvent se){
		System.out.println(se.getSession().getId() + "���������� --> ��������" + se.getName() + "���������ݣ�" + se.getValue()) ;
	}
	public void attributeRemoved(HttpSessionBindingEvent se){
		System.out.println(se.getSession().getId() + "��ɾ������ --> ��������" + se.getName() + "���������ݣ�" + se.getValue()) ;
	}
	public void attributeReplaced(HttpSessionBindingEvent se){
		System.out.println(se.getSession().getId() + "���滻���� --> ��������" + se.getName() + "���������ݣ�" + se.getValue()) ;
	}
}
/*
	<listener>
		<listener-class>
			org.lxh.listenerdemo.HttpSessionAttributeListenerDemo
		</listener-class>
	</listener>
*/