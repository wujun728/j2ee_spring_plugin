package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;
import com.itheima.exception.IdIsNullException;
import com.itheima.web.common.Page;

public interface BusinessService {
	/**
	 * ��ѯ���еĿͻ���Ϣ
	 * @return
	 */
	@Deprecated
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
	/**
	 * �����û�Ҫ�鿴��ҳ�룬��ѯ��װ�����з�ҳ��Ϣ��Pageʵ��
	 * @param pageNum ���Ϊnull��"",Ĭ��Ϊ1
	 * @return
	 */
	Page findPage(String pageNum);
	
}
