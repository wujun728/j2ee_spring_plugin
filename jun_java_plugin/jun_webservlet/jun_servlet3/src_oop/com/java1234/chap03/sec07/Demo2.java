package com.java1234.chap03.sec07;

public class Demo2 {

	/**
	 * �����
	 */
	{
		System.out.println("ͨ�ù����");
	}
	
	/**
	 * ���췽��һ
	 */
	public Demo2(){
		System.out.println("���췽��һ");
	}
	
	/**
	 * ���췽����
	 */
	public Demo2(int i){
		System.out.println("���췽����");
	}
	
	/**
	 * ���췽����
	 */
	public Demo2(int i,int j){
		System.out.println("���췽����");
	}
	
	public static void main(String[] args) {
		new Demo2();
		new Demo2(1);
		new Demo2(1,2);
	}
}
