package com.java1234.chap03.sec03;

public class Person2 {

	/**
	 * 
	 * @param name ��������
	 */
	void speak(String name){
		System.out.println("����"+name);
	}
	
	public static void main(String[] args) {
		Person2 zhangsan=new Person2();
		zhangsan.speak("����");
	}
}
