package com.java1234.chap02;

import java.util.Scanner;

public class Demo14 {

	public static void main(String[] args) {
		System.out.println("������һ�����֣�");
		// ctrl+shift+o
		Scanner scanner=new Scanner(System.in);
		String str=scanner.next();
		scanner.close();
		switch(str){
			case "����":{
				System.out.println("�����������");
				break;
			}case "����":{
				System.out.println("�����������");
				break;
			}
			default:{
				System.out.println("������������ַ���");
			}
				
		}
	}
}
