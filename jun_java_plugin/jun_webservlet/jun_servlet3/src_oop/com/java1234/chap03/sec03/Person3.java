package com.java1234.chap03.sec03;

public class Person3 {

	/**
	 * 
	 * @param name ��������
	 * @param age �������
	 */
	void speak(String name,int age){
		System.out.println("����"+name+",�ҽ���"+age+"����");
	}
	
	public static void main(String[] args) {
		Person3 zhangsan=new Person3();
		zhangsan.speak("����",23);
	}
}
