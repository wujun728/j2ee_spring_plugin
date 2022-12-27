package org.myframework.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @rem: ����˵��:����AJAXӦ�õ��������⣻ʹ�ñ����������ύAJAX����ʱ����ʹ��POST��ʽ��
 * @author: ����
 * @version: 1.0
 * @since 20100408
 */
public class MyEncodingFilter extends OncePerRequestFilter {
	public static class Timer {
		private long initTime;

		public long getCostTime() {
			// log.debug("end Time-------" + System.currentTimeMillis() );
			long costTime = System.currentTimeMillis() - initTime;
			// log.debug("cost Time-------" + costTime);
			return costTime;
		}

		public Timer() {
			initTime = System.currentTimeMillis();
			// log.debug("start Time-------" + initTime );
		}
	}

	public MyEncodingFilter() {
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setLogVisitHis(boolean logVisitHis) {
		this.logVisitHis = logVisitHis;
	}

	/*
	 * �����������ӣ�1.���б������ã�2.��¼��MENU_INFO���м�¼��URI
	 */
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Timer timer = new Timer();
		request.setAttribute(DEFAULT_TIMER_ATTRIBUTE, timer);

		String requestEncoding = getRequestEncoding(request, encoding);
		request.setCharacterEncoding(requestEncoding);
		response.setCharacterEncoding(encoding); // TOMCAT����ʱ�þ䲻��ע�͵�
		filterChain.doFilter(request, response);
		if (logVisitHis) {
			logUrlVisitHis(request);
		}
	}

	/**
	 * JQUERY ��AJAX POST����ʹ��UTF-8���� ,�������ʹ��Ĭ�ϱ���
	 * 
	 * @param request
	 * @param defaultEncoding
	 * @return
	 */
	private String getRequestEncoding(HttpServletRequest request,
			String defaultEncoding) {
		String encoding = "";
		String requestedWith = request.getHeader("X-Requested-With");
		String contentType = request.getContentType();
		if ("XMLHttpRequest".equalsIgnoreCase(requestedWith)
				&& contentType != null
				&& contentType.startsWith("application/x-www-form-urlencoded")) {
			encoding = AJAX_POST_ENCODING;
		} else {
			encoding = defaultEncoding;
		}
		return encoding;
	}

	/**
	 * 
	 * ��¼Ա���Բ�ְͬλ����URI����ʷ
	 * 
	 * @param request
	 */
	private void logUrlVisitHis(HttpServletRequest request) {
	}

	private static String AJAX_POST_ENCODING = "UTF-8";
	public static final String DEFAULT_TIMER_ATTRIBUTE = "ims.timer";
	private static final Log log = LogFactory.getLog(MyEncodingFilter.class);
	private String encoding;
	private boolean logVisitHis;

}
