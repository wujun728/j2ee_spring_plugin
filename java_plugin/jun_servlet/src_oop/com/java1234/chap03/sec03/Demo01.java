package com.java1234.chap03.sec03;

public class Demo01 {

	int add(int a,int b){
		System.out.println("����һ");
		return a+b;
	}
	
	/**
	 * ���������أ�����������һ��
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	int add(int a,int b,int c){
		System.out.println("������");
		return a+b+c;
	}
	
	/**
	 * ���������أ����������Ͳ�һ��
	 * @param a
	 * @param b
	 * @return
	 */
	int add(int a,String b){
		System.out.println("������");
		return a+Integer.parseInt(b);
	}
	
	/**
	 * �������͸���һ��������ֵ���Ͳ�һ�����������أ�ֱ�ӻᱨ���  ��˵��������
	 * @param args
	 */
	/*long add(int a,int b){
		return a+b;
	}*/
	
	public static void main(String[] args) {
		Demo01 demo=new Demo01();
		System.out.println(demo.add(1, 2));
		System.out.println(demo.add(1, 2, 3));
		System.out.println(demo.add(1, "3"));
		
		/*int m=demo.add(1, 2);
		long n=demo.add(1, 3);
		
		demo.add(1, 3);*/
	}
}
