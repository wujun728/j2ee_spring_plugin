package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//DriverManager���
public class JdbcDemo2 {

	public static void main(String[] args) throws Exception {
		//��ʽһ��������ʹ��
//		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//��ʽ����
		Class.forName("com.mysql.jdbc.Driver");
		
//---------------------------------------------------------------------------------------
//		2����ȡ�����ݿ������
		//��ʽһ��
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15", "root", "sorry");
		
		//��ʽ����
//		Properties props = new Properties();
//		props.setProperty("user", "root");//  ���������ο����ݿ���ĵ�
//		props.setProperty("password", "sorry");
//		props.setProperty("useUnicode", "true");//�����йصĲ���
//		props.setProperty("characterEncoding", "utf8");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15",props);
		
		//��ʽ��
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15?user=root&password=sorry");
		
		//System.out.println(conn.getClass().getName()); Ҫ��֪���������ͣ�����ô��
//		3����������SQL���Ķ���
		Statement stmt = conn.createStatement();
//		4��ִ��SQL���
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
//		5������ǲ�ѯ��䣬��Ҫ���������
		while(rs.next()){
			System.out.println("---------------------");
			System.out.println(rs.getObject("id"));
			System.out.println(rs.getObject("name"));
			System.out.println(rs.getObject("password"));
			System.out.println(rs.getObject("email"));
			System.out.println(rs.getObject("birthday"));
		}
//		6���ͷ�ռ�õ���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

}
