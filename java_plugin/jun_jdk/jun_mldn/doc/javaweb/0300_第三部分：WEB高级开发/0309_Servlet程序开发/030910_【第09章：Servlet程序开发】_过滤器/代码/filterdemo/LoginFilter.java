package org.lxh.filterdemo ;
import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
public class LoginFilter implements Filter {
	public void init(FilterConfig config)
          throws ServletException{
	}
	public void doFilter(ServletRequest request,
              ServletResponse response,
              FilterChain chain)
              throws IOException,
                     ServletException{
		// session����httpЭ��ķ���
		HttpServletRequest req = (HttpServletRequest) request ;
		HttpSession ses = req.getSession() ;
		if(ses.getAttribute("userid") != null) {
			// �Ѿ���½���ˣ�����Է���
			chain.doFilter(request,response) ;
		} else {
			request.getRequestDispatcher("login.jsp").forward(request,response) ;
		}
	}
	public void destroy(){
	}
}