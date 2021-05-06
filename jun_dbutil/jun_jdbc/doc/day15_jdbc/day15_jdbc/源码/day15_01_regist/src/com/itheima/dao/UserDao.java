package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
	/**
	 * �����û�����ѯ�û��Ƿ����
	 * @param username
	 * @return �����ڷ���null
	 */
	User findByUsername(String username);
	/**
	 * �����û���Ϣ
	 * @param user
	 */
	void save(User user);
	/**
	 * �����û����������ѯ�û�
	 * @param username
	 * @param password
	 * @return �û�����������󣬷���null
	 */
	User findUser(String username, String password);

}
