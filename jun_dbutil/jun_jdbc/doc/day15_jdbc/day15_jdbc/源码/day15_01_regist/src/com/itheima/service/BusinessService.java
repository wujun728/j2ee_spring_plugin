package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.exception.UserHasExistException;

public interface BusinessService {
	/**
	 * ע�����û�
	 * @param user ��װ���û���Ϣ��user����
	 * @throws UserHasExistException ����û����Ѿ����ڣ��׳����쳣
	 */
	void regist(User user) throws UserHasExistException;
	/**
	 * �û���¼
	 * @param username �û���
	 * @param password ����
	 * @return �û�����������󣬷���null
	 */
	User login(String username,String password);
}
