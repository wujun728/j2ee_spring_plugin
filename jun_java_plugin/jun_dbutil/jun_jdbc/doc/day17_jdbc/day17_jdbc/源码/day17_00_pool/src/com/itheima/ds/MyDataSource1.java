package com.itheima.ds;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import com.itheima.util.JdbcUtil;

public class MyDataSource1 implements DataSource {
	
	private static List<Connection> pool = Collections.synchronizedList(new ArrayList<Connection>());
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
	
	//�ӳ��л�ȡ����  >  com.mysql.jdbc.Connection
	public Connection getConnection() throws SQLException {
		if(pool.size()>0){
			Connection conn = pool.remove(0);
			MyConnection1 mconn = new MyConnection1(conn,pool);
			return mconn;
		}else{
			throw new RuntimeException("��������æ");
		}
	}
	
	
	
	
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {

	}

	public void setLoginTimeout(int seconds) throws SQLException {

	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	
	public Connection getConnection(String username, String password)
			throws SQLException {
		return null;
	}
	
	
}
