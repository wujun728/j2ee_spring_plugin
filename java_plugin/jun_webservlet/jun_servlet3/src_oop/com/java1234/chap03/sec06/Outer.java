package com.java1234.chap03.sec06;

/**
 * �ⲿ��
 * @author user
 *
 */
public class Outer {

	private int a=1;
	
	/**
	 * �ڲ���
	 * @author user
	 *
	 */
	class Inner{
		public void show(){
			System.out.println(a); // ���Է����ʹ���ⲿ������ԣ�
		}
	}
	
	public void show(){
		Inner inner=new Inner();
		inner.show();
	}
	
	public static void main(String[] args) {
		Outer outer=new Outer();
		outer.show();
	}
}
