package com.java1234.chap03.sec03;

public class Person4 {

	/**
	 * 
	 * @param name ��������
	 * @param age �������
	 * @param hobbies ���� ���˲��̶�
	 */
	void speak(String name,int age,String ...hobbies){
		System.out.println("����"+name+",�ҽ���"+age+"����");
		for(String hobby:hobbies){
			System.out.print(hobby+" ");
		}
	}
	
	public static void main(String[] args) {
		Person4 zhangsan=new Person4();
		zhangsan.speak("����",23,"��Ӿ","����","����");
	}
}
