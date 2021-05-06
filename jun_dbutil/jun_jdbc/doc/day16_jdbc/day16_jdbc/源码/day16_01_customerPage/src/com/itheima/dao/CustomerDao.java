package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Customer;

public interface CustomerDao {
	@Deprecated
	List<Customer> findAll();

	void save(Customer c);

	Customer findById(String customerId);

	void update(Customer c);

	void delete(String customerId);
	/**
	 * �õ��ܼ�¼����
	 * @return
	 */
	int getTotalRecordsNum();
	/**
	 * ��ҳ��ѯ
	 * @param startIndex
	 * @param offset
	 * @return
	 */
	List<Customer> getPageRecords(int startIndex,int offset);

}
