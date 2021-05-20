package org.lxh.servletdemo ;
import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
public class InitParamServlet extends HttpServlet {
	private String initParam = null ;	// ���ڱ����ʼ������
	public void init() throws ServletException{
		System.out.println("*****************") ;
	}

	public void init(ServletConfig config) throws ServletException{
		System.out.println("#######################") ;
		this.initParam = config.getInitParameter("ref") ;	// ���յĳ�ʼ������������ʱΪref
	}

	public void doGet(HttpServletRequest req,
                     HttpServletResponse resp)
              throws ServletException,
                     IOException{
		System.out.println("** ��ʼ��������" + this.initParam) ;
	}
	public void doPost(HttpServletRequest req,
                     HttpServletResponse resp)
              throws ServletException,
                     IOException{
		this.doGet(req,resp) ;
	
	}



}
/*
	<servlet>
		<servlet-name>initparam</servlet-name>
		<servlet-class>org.lxh.servletdemo.InitParamServlet</servlet-class>
		<init-param>
			<param-name>ref</param-name>
			<param-value>www.MLDNJAVA.cn</param-value>
		</init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>initparam</servlet-name>
		<url-pattern>/InitParamServlet</url-pattern>
	</servlet-mapping>
*/