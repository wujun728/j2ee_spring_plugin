package com.itheima.dao;

import com.itheima.domain.Account;

//DAO�㣺����ǣ�����κ�ҵ���йص��߼���
//DAO:ֻ����CRUD
public interface AccountDao {
	/**
	 * ���ݻ�����ѯ�˻�
	 * @param accountName
	 * @return
	 */
	Account findByName(String accountName);
	/**
	 * �����˻�
	 * @param account
	 */
	void updateAcount(Account account);
}
