package org.lxh.servletdemo ;
import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
public class HttpSessionDemoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession ses = req.getSession() ;
		System.out.println("SESSION ID --> " + ses.getId()) ;
		ses.setAttribute("username","���˻�") ;	 // ����session����
		System.out.println("username�������ݣ�" + ses.getAttribute("username")) ;
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(req,resp) ;
	}
}
/*
	<servlet>
		<servlet-name>sessiondemo</servlet-name>
		<servlet-class>
			org.lxh.servletdemo.HttpSessionDemoServlet
		</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>sessiondemo</servlet-name>
		<url-pattern>/HttpSessionDemoServlet</url-pattern>
	</servlet-mapping>
*/