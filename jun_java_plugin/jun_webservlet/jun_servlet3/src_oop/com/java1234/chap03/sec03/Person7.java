package com.java1234.chap03.sec03;

class SanWei{
	int b;  // ��Χ
	int w;  // ��Χ
	int h;  // ��Χ
}

public class Person7 {

	
	void speak(int age,SanWei sanWei){
		System.out.println("�ҽ���"+age+"����");
		System.out.println("�ҵ���Χ�ǣ�"+sanWei.b+","+sanWei.w+","+sanWei.h);
		age=24;
		System.out.println("������age"+age);
		sanWei.b=80; // ��Χ��ˮ
	}
	
	public static void main(String[] args) {
		Person7 zhangsan=new Person7();
		int age=23;
		SanWei sanWei=new SanWei();
		sanWei.b=90;
		sanWei.w=60;
		sanWei.h=90;
		zhangsan.speak(age,sanWei);
		System.out.println(age);
		System.out.println("���õط�����Χ"+sanWei.b);
	}
}
