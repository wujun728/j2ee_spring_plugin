package com.itheima.dao;

public interface AccountDao {
	/**
	 * ת��
	 * @param sourceAccountName ת���˻�
	 * @param targetAccontName ת���˻�
	 * @param money ���׽��
	 */
	void transfer(String sourceAccountName,String targetAccontName,float money);
}
