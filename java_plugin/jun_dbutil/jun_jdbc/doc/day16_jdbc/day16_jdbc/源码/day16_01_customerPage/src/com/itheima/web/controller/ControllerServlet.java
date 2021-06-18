package com.itheima.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.itheima.domain.Customer;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;
import com.itheima.util.FormBeanUtil;
import com.itheima.web.bean.CustomerFormBean;
import com.itheima.web.common.Page;

public class ControllerServlet extends HttpServlet {
	private String encoding = "UTF-8";
	private BusinessService s = new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		String op = request.getParameter("op");
		if("showAllCustomers".equals(op)){
			showAllCustomers(request,response);
		}else if("addCustomer".equals(op)){
			addCustomer(request,response);
		}else if("editCustomerUI".equals(op)){
			editCustomerUI(request,response);
		}else if("editCustomer".equals(op)){
			editCustomer(request,response);
		}else if("delOne".equals(op)){
			delOne(request,response);
		}else if("delMulti".equals(op)){
			delMulti(request,response);
		}
		
	}
	private void delMulti(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException{
		String ids[] = request.getParameterValues("ids");
		for(String id:ids){
			s.deleteCustomerById(id);
		}
		response.sendRedirect(request.getContextPath());
	}
	//����idɾ��һ���ͻ���Ϣ
	private void delOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		s.deleteCustomerById(id);
		response.sendRedirect(request.getContextPath());
	}
	//�����޸ĺ����Ϣ
	private void editCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		try {
			//��װ���ݵ�formbean
			CustomerFormBean formBean = FormBeanUtil.fillBean(request, CustomerFormBean.class);
			if(!formBean.validate()){
				request.setAttribute("formBean", formBean);
				request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
				return;
			}
			//���ģ��
			Customer c = new Customer();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(c, formBean);
			//����������
			
			String hobbies[] = request.getParameterValues("hobbies");
			if(hobbies!=null&&hobbies.length>0){
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<hobbies.length;i++){
					if(i>0)
						sb.append(",");
					sb.append(hobbies[i]);
				}
				c.setHobby(sb.toString());
			}
			
			s.updateCustomer(c);
			response.getWriter().write("����ɹ���2����Զ�ת����ҳ");
			response.setHeader("Refresh", "2;URL="+request.getContextPath());
			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("������æ");
		}
	}
	//����id��ѯ�ͻ���Ϣ
	private void editCustomerUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		Customer c = s.findCustomerById(id);
		request.setAttribute("c", c);
		request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
	}
	//����ͻ���Ϣ
	private void addCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		try {
			//��װ���ݵ�formbean
			CustomerFormBean formBean = FormBeanUtil.fillBean(request, CustomerFormBean.class);
			if(!formBean.validate()){
				request.setAttribute("formBean", formBean);
				request.getRequestDispatcher("/addCustomer.jsp").forward(request, response);
				return;
			}
			//���ģ��
			Customer c = new Customer();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(c, formBean);
			//����������
			
			String hobbies[] = request.getParameterValues("hobbies");
			if(hobbies!=null&&hobbies.length>0){
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<hobbies.length;i++){
					if(i>0)
						sb.append(",");
					sb.append(hobbies[i]);
				}
				c.setHobby(sb.toString());
			}
			
			s.saveCustomer(c);
			response.getWriter().write("����ɹ���2����Զ�ת����ҳ");
			response.setHeader("Refresh", "2;URL="+request.getContextPath());
			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("������æ");
		}
	}
	//��ѯ���пͻ���Ϣ
	private void showAllCustomers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
//		List<Customer> cs = s.findAllCustomers();
//		request.setAttribute("cs", cs);
		
		String num = request.getParameter("num");//�õ��û�Ҫ����ҳ��
		Page page = s.findPage(num);
		page.setUrl("/servlet/ControllerServlet?op=showAllCustomers");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listCustomers.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
