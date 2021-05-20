package com.itheima.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import com.itheima.util.DBCPUtil;

//���ݿ�Ԫ��Ϣ�Ļ�ȡ
public class Demo {
	//���ݿⱾ����Ϣ�Ļ�ȡ
	@Test
	public void test1() throws Exception{
		Connection conn = DBCPUtil.getConnection();
		DatabaseMetaData dmd = conn.getMetaData();
		String name = dmd.getDatabaseProductName();//��֪��˵ʲô����
		System.out.println(name);
		int isolation = dmd.getDefaultTransactionIsolation();
		System.out.println(isolation);
	}
	//����Ԫ������Ϣ��PreparedStatementʱ
	@Test
	public void test2() throws Exception{
		Connection conn = DBCPUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("??????????");
		
		ParameterMetaData pmd = stmt.getParameterMetaData();
		int count = pmd.getParameterCount();
		System.out.println(count);//ͳ������е�ռλ������
	}
	//�����Ԫ������Ϣ��
	@Test
	public void test3()throws Exception{
		Connection conn = DBCPUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from account");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();//�м���
		System.out.println(count);
		
		for(int i=0;i<count;i++){
			String fieldName = rsmd.getColumnName(i+1);
			int type = rsmd.getColumnType(i+1);
			System.out.println(fieldName+":"+type);
		}
	}
}
