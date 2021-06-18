package com.itheima.jdbc;

import java.sql.Connection;

import org.junit.Test;

import com.itheima.util.JdbcUtil;
//���ø��뼶��
public class IsolationLevelDemo {
	@Test
	public void test1() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		//һ��Ҫ�ڿ�������ǰ���ĸ��뼶��
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		conn.setAutoCommit(false);
		
//		....
		conn.commit();
	}
}
