package com.itheima.ds;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
��Ҳ�ǰ�װ����ConnectionAdapter���а�װ��

��װ�༴�Ǳ���װ��İ�װ�������������ࡣ

1����дһ���࣬�̳��Ѿ��ǰ�װ����ࡣ
2������һ�����������ñ���װ���ʵ����
3�����幹�췽�������뱻��װ���ʵ����
4�����ǵ���Ҫ��д�ķ���
 */
public class MyConnection1 extends ConnectionAdapter {
	private Connection conn;
	private List<Connection> pool;
	public MyConnection1(Connection conn,List<Connection> pool){
		super(conn);
		this.conn = conn;
		this.pool = pool;
	}
	public void close() throws SQLException {
		pool.add(conn);
	}
	
}
