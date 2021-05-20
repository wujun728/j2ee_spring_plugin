package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import com.itheima.util.JdbcUtil;

//���������������ݿ�Ľ�������������ִ��Ч��
public class BatchDemo {
	
	/*
	 create database day16;
	 use day16;
	 create table t1(
	 	id int primary key,
	 	name varchar(100)
	 );
	 */
	
	//�����ݿ��в���2����¼���ٰѵ�һ��ɾ����
	//Statement������������䲻ͬ�ġ�
	@Test
	public void test1() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = conn.createStatement();
		String sql1 = "insert into t1 values(1,'aaa1')";
		String sql2 = "insert into t1 values(2,'aaa2')";
		String sql3 = "delete from t1 where id=1";
		stmt.addBatch(sql1);//Statementʵ���ڲ���һ��List��sql���ӵ�List����
		stmt.addBatch(sql2);
		stmt.addBatch(sql3);
		
		int[] ii = stmt.executeBatch();//����ֵ��һ�����飬�����Ԫ��Ϊÿ�����Ӱ�쵽������
		for(int i:ii)
			System.out.println(i);
		
		JdbcUtil.release(null, stmt, conn);
		
	}
	 
	//����10����¼��PreparedStatement �ʺ������ͬ��ֻ�ǲ�����ͨ�����
	@Test
	public void test2() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into t1 values (?,?)");
		for(int i=0;i<10;i++){
			stmt.setInt(1, i+1);
			stmt.setString(2, "aaaa"+(i+1));
			stmt.addBatch();
		}
		
		stmt.executeBatch();
		JdbcUtil.release(null, stmt, conn);
	}
	
	//����1000001����¼��PreparedStatement �ʺ������ͬ��ֻ�ǲ�����ͨ�����
	@Test
	public void test3() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into t1 values (?,?)");
		for(int i=0;i<1000001;i++){
			stmt.setInt(1, i+1);
			stmt.setString(2, "aaaa"+(i+1));
			stmt.addBatch();
			if(i%1000==0){
				stmt.executeBatch();
				stmt.clearBatch();//������
			}
		}
		
		stmt.executeBatch();
		JdbcUtil.release(null, stmt, conn);
	}
}
