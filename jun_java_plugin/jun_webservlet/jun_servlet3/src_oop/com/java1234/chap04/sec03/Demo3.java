package com.java1234.chap04.sec03;

public class Demo3 {

	public static void testThrows() throws NumberFormatException{
		String str="123a";
		int a=Integer.parseInt(str);
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		try{
			testThrows();			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("���������ﴦ���쳣");
		}
		System.out.println("I'm here");
	}
}
