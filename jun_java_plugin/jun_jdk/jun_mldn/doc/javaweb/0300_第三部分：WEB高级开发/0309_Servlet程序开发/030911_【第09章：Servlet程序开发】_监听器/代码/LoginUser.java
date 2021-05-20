package org.lxh.listenerdemo ;
import javax.servlet.http.* ;
public class LoginUser implements HttpSessionBindingListener {
	private String name ;
	public LoginUser(String name){
		this.setName(name) ;
	}
	public void valueBound(HttpSessionBindingEvent event){
		System.out.println("** ��session�б���LoginUser����name = " + this.getName() + "����session id = " + event.getSession().getId()) ;
	}
	public void valueUnbound(HttpSessionBindingEvent event){
		System.out.println("** ��session���Ƴ�LoginUser����name = " + this.getName() + "����session id = " + event.getSession().getId()) ;
	}
	public String getName(){
		return this.name ;
	}
	public void setName(String name){
		this.name = name ;
	}
}