package com.java1234.chap03.sec03;

public class Person6 {

	
	void speak(int age){
		System.out.println("�ҽ���"+age+"����");
		age=24;
		System.out.println("������age"+age);
	}
	
	public static void main(String[] args) {
		Person6 zhangsan=new Person6();
		int age=23;
		zhangsan.speak(age);
		System.out.println(age);
	}
}
