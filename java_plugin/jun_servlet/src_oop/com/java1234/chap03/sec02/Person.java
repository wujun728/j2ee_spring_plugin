package com.java1234.chap03.sec02;

/**
 * Person��  �ļ�������������һ��
 * @author user
 *
 */
public class Person {

	String name; // �����У�����һ������name�ַ������ԣ����Դ���ַ���  "����"
	int age; // ������ ������һ������age����
	
	/**
	 * ����һ������
	 */
	public void speak(){
		System.out.println("�ҽ�"+name+" �ҽ���"+age);
	}
	
	public static void main(String[] args) {
		// ����һ��Person��Ķ���zhangsan
		Person zhangsan; 
		// ʵ��������
		zhangsan=new Person();
		zhangsan.name="����";  // �������name���Ը�ֵ
		zhangsan.age=1; // �������age���Ը�ֵ
		zhangsan.speak(); // ���ö���ķ���
	}
}
