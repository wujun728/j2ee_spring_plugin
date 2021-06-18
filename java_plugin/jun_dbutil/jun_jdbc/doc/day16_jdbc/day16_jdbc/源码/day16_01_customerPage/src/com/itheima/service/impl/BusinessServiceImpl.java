package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.exception.IdIsNullException;
import com.itheima.service.BusinessService;
import com.itheima.util.IdGenertor;
import com.itheima.web.common.Page;

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

	public Page findPage(String pageNum) {
		int num = 1;//�û�Ҫ����ҳ��,Ĭ����1
		if(pageNum!=null&&!pageNum.trim().equals("")){//�����û�Ҫ����ҳ��
			num = Integer.parseInt(pageNum);
		}
		int totalRecords = dao.getTotalRecordsNum();//�õ��ܼ�¼������
		Page page = new Page(num, totalRecords);//���󴴽�������,�ܶ�Ĳ������Ѿ��������
		
		//��ѯ��ҳ��¼
		List records = dao.getPageRecords(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		return page;
	}

}
