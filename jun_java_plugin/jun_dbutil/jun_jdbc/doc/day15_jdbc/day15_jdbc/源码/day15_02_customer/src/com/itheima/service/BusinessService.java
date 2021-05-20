package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;
import com.itheima.exception.IdIsNullException;

public interface BusinessService {
	/**
	 * ��ѯ���еĿͻ���Ϣ
	 * @return
	 */
	List<Customer> findAllCustomers();
	/**
	 * ��ӿͻ���Ϣ
	 * @param c
	 */
	void saveCustomer(Customer c);
	/**
	 * ����id��ѯ�ͻ���Ϣ
	 * @param customerId
	 * @return �����ڷ���null
	 */
	Customer findCustomerById(String customerId);
	/**
	 * ���¿ͻ���Ϣ
	 * @param c
	 * @throws IdIsNullException �ͻ���id���Ϊnull����"",�׳����쳣
	 */
	void updateCustomer(Customer c) throws IdIsNullException;
	/**
	 * ����idɾ���ͻ���Ϣ
	 * @param customerId
	 */
	void deleteCustomerById(String customerId);
	
}
