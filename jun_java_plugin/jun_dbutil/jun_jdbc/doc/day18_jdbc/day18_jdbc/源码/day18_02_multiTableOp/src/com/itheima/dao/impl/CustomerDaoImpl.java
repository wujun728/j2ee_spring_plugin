package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.util.DBCPUtil;

public class CustomerDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void saveCustomer(Customer c){
		try {
			qr.update("insert into customers (id,name,city) values(?,?,?)",
					c.getId(),c.getName(),c.getCity());
			//���涩������Ϣ����������
			List<Order> os = c.getOrders();
			if(os.size()>0){
				for(Order o:os){
					qr.update("insert into orders (id,num,price,customer_id) values(?,?,?,?)", 
						o.getId(),o.getNum(),o.getPrice(),c.getId());
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//�ͻ�����ҵ��Ļ������Ķ���Ҫ��Ҫ��ѯ�����أ� ������
	// ��ѯ�ͻ�ʱ�Ѷ�Ӧ�Ķ���Ҳ��ѯ�������������أ�
	public Customer findCustomerById(int customerId){
		try {
			Customer c = qr.query("select * from customers where id=?", new BeanHandler<Customer>(Customer.class),customerId);
			if(c!=null){
				//�鶩��
				List<Order> os = qr.query("select * from orders where customer_id=?", new BeanListHandler<Order>(Order.class),customerId);
				c.setOrders(os);
			}
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
