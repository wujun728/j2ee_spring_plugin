package com.itheima.util;

import java.sql.Connection;
import java.sql.SQLException;
//��װ�������������йصķ���
public class TransactionManager {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	public static Connection getConnection(){
		Connection conn = tl.get();
		if(conn==null){//�ӵ�ǰ�߳��л�ȡ����
			conn = DBCPUtil.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	public static void startTransaction(){
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(){
		try {
			Connection conn = getConnection();
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(){
		try {
			Connection conn = getConnection();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void release(){
		try {
			Connection conn = getConnection();
			conn.close();
			tl.remove();//�ӵ�ǰ�߳��н��  �������ʵ���йأ������������̳߳ء�
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
