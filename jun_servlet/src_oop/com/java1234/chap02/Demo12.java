package com.java1234.chap02;

public class Demo12 {

	public static void main(String[] args) {
		int a=1;
		
		// if���
		// ����ע�Ϳ�ݷ�ʽ ctrl+shift+/
		/*if(a>0){
			System.out.println(a+"������");
		}*/
		
		// if ..else���
		/*if(a>0){
			System.out.println(a+"������");
		}else{
			System.out.println(a+"��������");
		}*/
		
		// if ...else if ...else
		if(a>0){
			System.out.println(a+"������");
		}else if(a<0){
			System.out.println(a+"�Ǹ���");
		}else{
			System.out.println(a+"��0");
		}
	}
}
