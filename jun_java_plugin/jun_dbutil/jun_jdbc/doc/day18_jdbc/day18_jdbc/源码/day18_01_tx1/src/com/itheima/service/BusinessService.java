package com.itheima.service;

public interface BusinessService {
	/**
	 * ת��
	 * @param sourceAccountName ת���˻�
	 * @param targetAccontName ת���˻�
	 * @param money ���׽��
	 */
	void transfer(String sourceAccountName,String targetAccontName,float money);
}
