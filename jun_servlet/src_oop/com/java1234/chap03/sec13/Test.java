package com.java1234.chap03.sec13;

public class Test {

	public static void main(String[] args) {
		// ��������ָ��Dog����ľ���ʵ��
		Animal animal=new Dog();
		animal.say();
		
		// ����ת��
		Dog dog=(Dog) animal;
		dog.say();
		
		// ����ת�� 
		Cat cat=(Cat) animal;
		cat.say();
		
	}
}
