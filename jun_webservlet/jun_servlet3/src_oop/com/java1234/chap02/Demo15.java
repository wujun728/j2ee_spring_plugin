package com.java1234.chap02;

public class Demo15 {

	public static void main(String[] args) {
		// �ڿ���̨���1��10
		// whileѭ�����
		int i=1;
		while(i<=10){
			System.out.print(i+" ");
			i++;
		}
		
		System.out.println("====================");
		// do...whileѭ�����
		int j=1;
		do{
			System.out.print(j+" ");
			j++;
		}while(j<=10);
		
		System.out.println("====================");
		// forѭ��
		for(int k=1;k<=10;k++){
			System.out.print(k+" ");
		}
		
		System.out.println("====================");
		
		// forѭ����Ƕ��
		for(int m=0;m<10;m++){
			for(int n=0;n<10;n++){
				System.out.print("m="+m+",n="+n+" ");
			}
			System.out.println();
		}
	}
}
