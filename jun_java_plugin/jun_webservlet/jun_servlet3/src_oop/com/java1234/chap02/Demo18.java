package com.java1234.chap02;

public class Demo18 {

	public static void main(String[] args) {
		/*// ����һ������ int���͵�����
		int []arr;
		// ����һ�ַ�ʽ
		int arr2[];*/
		
		/*// ����һ�����飬���Ҿ�̬��ʼ��
		int arr[]=new int[]{1,2,3};
		
		//��ͨ�����������ʽ
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println("==============");
		
		// foreach��ʽ
		for(int j:arr){
			System.out.println(j);
		}*/
		
		int arr[]=new int[3];
		arr[0]=1; // ������Ԫ�ظ�ֵ
		arr[2]=6; 
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
