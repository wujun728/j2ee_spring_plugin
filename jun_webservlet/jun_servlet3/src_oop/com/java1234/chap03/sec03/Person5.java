package com.java1234.chap03.sec03;

public class Person5 {

	/**
	 * 
	 * @param name
	 * @param age
	 * @param hobbies
	 * @return ���ذ��õĸ���
	 */
	int speak(String name,int age,String ...hobbies){
		System.out.println("����"+name+",�ҽ���"+age+"����");
		for(String hobby:hobbies){
			System.out.print(hobby+" ");
		}
		int totalHobbies=hobbies.length;
		return totalHobbies;
	}
	
	public static void main(String[] args) {
		Person5 zhangsan=new Person5();
		int n=zhangsan.speak("����",23,"��Ӿ","����","����");
		System.out.println("��"+n+"������");
	}
}
