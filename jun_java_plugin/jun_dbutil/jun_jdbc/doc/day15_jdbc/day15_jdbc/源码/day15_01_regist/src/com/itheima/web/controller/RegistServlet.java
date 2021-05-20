package com.itheima.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.omg.CORBA.UserException;

import com.itheima.domain.User;
import com.itheima.exception.UserHasExistException;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;
import com.itheima.util.BeanUtil;
import com.itheima.web.bean.UserFormBean;
//��ϰ�ص�
public class RegistServlet extends HttpServlet {
	private BusinessService s = new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserFormBean formBean = null;
		try {
			//��װ����
			formBean = BeanUtil.fillBean(request, UserFormBean.class);
			//��֤���ݵĺϷ���:����
			if(!formBean.validate()){
				request.setAttribute("formBean", formBean);
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			//���ģ�ͣ�����(��FormBean�е����ݣ��㵽JavaBean�С�ע�����͵�ת��)
			
			User user = new User();
//		user.setUsername(formBean.getUsername());
//		user.setPassword(formBean.getPassword());
//		user.setEmail(formBean.getEmail());
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		user.setBirthday(df.parse(formBean.getBirthday()));
			
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formBean);//��㷴��
			
			
			//�������ݣ�����ҵ��㣬�����ɹ���ʾ
			s.regist(user);
			response.sendRedirect(request.getContextPath());//�ɹ����ض�����ҳ
		}catch(UserHasExistException e){
			//�û������ڵ����⣺����  ץ�쳣����ʽ����
			formBean.getErrors().put("username", e.getMessage());
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
