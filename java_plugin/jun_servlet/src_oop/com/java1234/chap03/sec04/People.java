package com.java1234.chap03.sec04;

/**
 * ����
 * @author user
 *
 */
public class People {

	// �������� 
	private String name; // ʵ���������ʱ��Ĭ��ֵ��null
	private int age; // ʵ���������ʱ��Ĭ��ֵ��0
	
	/**
	 * Ĭ�ϵĹ��췽��
	 */
	public People(){
		System.out.println("Ĭ�Ϲ��췽��");
	}
	
	/**
	 * �в����Ĺ��췽��
	 * @param name2
	 * @param age2
	 */
	People(String name,int age){
		this();// �����޲����Ĺ��췽��
		System.out.println("���õ����в����Ĺ��췽��");
		this.name=name;
		this.age=age;
	}
	
	
	public void say(){
		System.out.println("�ҽУ�"+name+"���ҽ��꣺"+age);
	}
	
	public static void main(String[] args) {
		// People zhangsan=new People();
		People zhangsan=new People("����",20);
		zhangsan.say();
	}
}
