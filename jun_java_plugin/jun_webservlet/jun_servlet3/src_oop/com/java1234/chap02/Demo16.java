package com.java1234.chap02;

public class Demo16 {

	public static void main(String[] args) {
		for(int i=100;i<=999;i++){  // ����i=253
			int b=i/100; // �����λ��  253  253/100=2
			int s=(i-b*100)/10; // ���ʮλ�� 253 (253-2*100)/10=53/10=5
			int g=i-b*100-s*10; // �����λ�� 253 253-2*100-5*10=53-50=3
			if(i==b*b*b+s*s*s+g*g*g){
				System.out.print(i+" ");
			}
		}
	}
}
