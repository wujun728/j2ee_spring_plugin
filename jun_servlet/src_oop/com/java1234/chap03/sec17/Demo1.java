package com.java1234.chap03.sec17;

public class Demo1 {

	public static void main(String[] args) {
		int a=1; 
		Integer i=new Integer(a); // װ��
		int b=i.intValue(); // ����
		System.out.println("a="+a);
		System.out.println("i="+i);
		System.out.println("b="+b);
	}
}
