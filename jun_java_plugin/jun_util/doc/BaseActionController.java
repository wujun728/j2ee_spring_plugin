package org.myframework.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.myframework.jdbc.MyJdbcTemplate;
import org.myframework.util.BeanUtil;
import org.myframework.util.MapUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

public class BaseActionController extends MultiActionController {
	protected final Log log = LogFactory.getLog(getClass());

	private static String RESULT_PAGE = "/common/resultPage"; // .jsp
	private static String JSON_PAGE = "/common/ajaxJson"; // .jsp

	protected static String MOD = "MOD"; // �޸�

	protected static String DEL = "DEL"; // ɾ��

	protected static String ADD = "ADD"; // ����

	protected static String JSONRESULT = "jsonResult";// JSON����ֵ

	private String jspPkg;

	@Resource(name = "MyJdbcTemplate")
	protected MyJdbcTemplate MyJdbcTemplate;

	public BaseActionController() {
		super();
		if (this.getClass().isAnnotationPresent(JspPkg.class)) {
			JspPkg jspPkgAnnotation = this.getClass().getAnnotation(
					JspPkg.class);
			jspPkg = jspPkgAnnotation.value();
		}
	}

	public BaseActionController(Object delegate) {
		super(delegate);
	}


	/**
	 * ���û��ָ��viewName����ת��Ĭ��JSP
	 * 
	 * @param request
	 * @return
	 */
	protected ModelAndView getReqView(HttpServletRequest request)
			throws NoSuchRequestHandlingMethodException {
		String viewName = request.getParameter("viewName");
		String handlerMethodName = this.getMethodNameResolver()
				.getHandlerMethodName(request);
		viewName = (viewName == null) ? handlerMethodName : viewName;
		ModelAndView view = MyDispatchServlet.getModelAndView();
		view.setViewName(jspPkg + viewName);
		log.debug("JSP Name :" + view.getViewName() + ".jsp");
		return view;
	}

	/**
	 * ����Ա��ֱ��ָ��JSP�ľ���·��
	 * 
	 * @param request
	 * @return
	 * @throws NoSuchRequestHandlingMethodException
	 */
	protected ModelAndView getCustomView(String viewName) {
		ModelAndView view = MyDispatchServlet.getModelAndView();
		view.setViewName(viewName);
		log.debug("JSP Name :" + view.getViewName() + ".jsp");
		return view;
	}

	/**
	 * AJAX����ʱת���JSP
	 * 
	 * @return
	 */
	protected ModelAndView getJSONPage() {
		return getCustomView(JSON_PAGE);
	}

	/**
	 * ָ��IFRAME�ص�ҳ��
	 * 
	 * @return
	 */
	protected ModelAndView getResultPage() {
		return getCustomView(RESULT_PAGE);
	}

	/**
	 * ����Request�ύ�Ĳ��� ������ֵ��model��
	 * 
	 * @param request
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	protected void parseRequest(Object model, HttpServletRequest request)
			throws Exception {
		Map requestMap = MapUtil.getMapFromRequest(request);
		log.debug("requestMap :" + requestMap);
		BeanUtil.copyProperties(model, requestMap);
	}

	/**
	 * @param map
	 */
	protected Map getQryMap(HttpServletRequest request) {
		Map map = MapUtil.getMapFromRequest(request);
		log.debug("getMapFromRequest-->" + map);
		Map newMap = new HashMap<String, Object>();
		Set<Map.Entry<String, Object>> set = map.entrySet();
		for (Iterator<Map.Entry<String, Object>> it = set.iterator(); it
				.hasNext();) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it
					.next();
			Object value = entry.getValue();
			if (value instanceof String) {
				String value1 = (String) value;
				if (value1.indexOf(",") > -1) {
					newMap.put(entry.getKey() + "List", value1.split(","));
				}
				newMap.put(entry.getKey(), "".equals(value) ? null : value);
			}
			newMap.putAll(map);
		}
		log.debug("getQryMap-->" + newMap);
		return newMap;
	}

	public void setJspPkg(String jspPkg) {
		this.jspPkg = jspPkg;
	}
}