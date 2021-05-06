package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.exception.UserHasExistException;
import com.itheima.service.BusinessService;
import com.itheima.util.DaoFactory;

public class BusinessServiceImpl implements BusinessService {
	private UserDao dao = DaoFactory.getUserDao();
	public void regist(User user) throws UserHasExistException {
		//�����û�����ѯ�û����Ƿ����
		User dbUser = dao.findByUsername(user.getUsername());
		if(dbUser!=null)
			throw new UserHasExistException("�û�����"+user.getUsername()+"Ӧ��������");
		dao.save(user);
	}

	public User login(String username, String password) {
		return dao.findUser(username,password);
	}

}
