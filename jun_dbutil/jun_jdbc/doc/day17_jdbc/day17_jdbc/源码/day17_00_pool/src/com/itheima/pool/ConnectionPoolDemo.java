package com.itheima.pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.itheima.util.JdbcUtil;

//ģ�����ݿ����ӳص�ԭ��
public class ConnectionPoolDemo {
	private static List<Connection> pool = new ArrayList<Connection>();
	static{
		try {
			for(int i=0;i<10;i++){
				Connection conn = JdbcUtil.getConnection();//������������
				pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//�ӳ���ȡ��һ������
	public synchronized static Connection getConnection(){
		if(pool.size()>0){
			Connection conn = pool.remove(0);
			return conn;
		}else{
			throw new RuntimeException("��������æ");
		}
	}
	//�����ӻ��س���
	public static void release(Connection conn){
		pool.add(conn);
	}
	
}
