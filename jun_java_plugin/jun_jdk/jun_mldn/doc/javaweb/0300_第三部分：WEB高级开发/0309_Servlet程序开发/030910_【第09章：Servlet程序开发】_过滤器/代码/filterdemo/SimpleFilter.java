package org.lxh.filterdemo ;
import java.io.* ;
import javax.servlet.* ;
public class SimpleFilter implements Filter {
	public void init(FilterConfig config)
          throws ServletException{
		// ���ճ�ʼ���Ĳ���
		String initParam = config.getInitParameter("ref") ;	
		System.out.println("** ��������ʼ������ʼ������=" + initParam) ;
	}
	public void doFilter(ServletRequest request,
              ServletResponse response,
              FilterChain chain)
              throws IOException,
                     ServletException{
		System.out.println("** ִ��doFilter()����֮ǰ") ;
		chain.doFilter(request,response) ;
		System.out.println("** ִ��doFilter()����֮��") ;
	}
	public void destroy(){
		System.out.println("** ���������١�") ;
	}
}