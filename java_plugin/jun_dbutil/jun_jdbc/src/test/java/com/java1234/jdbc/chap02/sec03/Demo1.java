package com.java1234.jdbc.chap02.sec03;

public class Demo1 {

	private static String jdbcName="com.mysql.jdbc.Driver";
			
	public static void main(String[] args) {
		try {
			Class.forName(jdbcName);
			System.out.println("���������ɹ���");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
	}
}
