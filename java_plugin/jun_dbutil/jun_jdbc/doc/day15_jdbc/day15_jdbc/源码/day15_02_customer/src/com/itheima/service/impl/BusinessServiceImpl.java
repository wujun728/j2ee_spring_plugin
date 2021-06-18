package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.exception.IdIsNullException;
import com.itheima.service.BusinessService;
import com.itheima.util.IdGenertor;

public class BusinessServiceImpl implements BusinessService {
	private CustomerDao dao = new CustomerDaoImpl();
	public List<Customer> findAllCustomers() {
		return dao.findAll();
	}

	public void saveCustomer(Customer c) {
		if(c==null)
			throw new IllegalArgumentException("������ȫ");
		c.setId(IdGenertor.genGUID());
		dao.save(c);
	}

	public Customer findCustomerById(String customerId) {
		return dao.findById(customerId);
	}

	public void updateCustomer(Customer c) throws IdIsNullException {
		if(c==null)
			throw new IllegalArgumentException("������ȫ");
		if(c.getId()==null||c.getId().trim().equals("")){
			throw new IdIsNullException("���µĿͻ���Ϣ��id����Ϊ��");
		}
		dao.update(c);
	}

	public void deleteCustomerById(String customerId) {
		if(customerId==null||customerId.trim().equals("")){
			throw new IllegalArgumentException("�ͻ���id����Ϊ��");
		}
		dao.delete(customerId);
	}

}
