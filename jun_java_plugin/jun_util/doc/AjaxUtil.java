package org.myframework.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AjaxUtil {
	private static Log log = LogFactory.getLog(AjaxUtil.class);

	/**
	 * ��request�л�ȡ���в�ѯ����ֵ����&abc=123�ķ�ʽ����
	 * @param request
	 * @return String
	 */
	public static String getUrlParam(HttpServletRequest request) {
		StringBuffer urlParam = new StringBuffer("");
		for (Enumeration elements = request.getParameterNames(); elements
				.hasMoreElements();) {
			String key = (String) elements.nextElement();
			String value = request.getParameter(key);
			urlParam.append("&" + key + "=" + value);
		}
		log.debug(urlParam.toString());
		return urlParam.toString();
	}

	/**
	 * ��request�л�ȡ���в�ѯ����ֵ����JSON����ķ�ʽ����
	 * @param request
	 * @return String
	 */
	public static String getJsonArray(HttpServletRequest request) {
		StringBuffer urlParam = new StringBuffer("[");
		for (Enumeration elements = request.getParameterNames(); elements
				.hasMoreElements();) {
			String key = (String) elements.nextElement();
			String value = request.getParameter(key);
			urlParam.append("{name:'" + key + "', value:'" + value + "'}");
		}
		urlParam.append("]");
		log.debug(urlParam.toString());
		return urlParam.toString();
	}
}
