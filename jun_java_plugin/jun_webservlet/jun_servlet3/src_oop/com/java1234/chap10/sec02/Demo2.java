package com.java1234.chap10.sec02;

import java.io.File;
import java.io.IOException;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		File file=new File("c://java������Ŀ¼//java�������ļ�.txt");
		if(file.exists()){ // �ж��ļ��Ƿ����
			boolean b=file.delete(); // ɾ���ļ�
			if(b){
				System.out.println("�ļ�ɾ���ɹ�");
			}else{
				System.out.println("�ļ�ɾ��ʧ��");
			}
			file=new File("c://java������Ŀ¼");
			if(file.exists()){
				boolean b2=file.delete(); // ɾ��Ŀ¼
				if(b2){
					System.out.println("Ŀ¼ɾ���ɹ�");
				}else{
					System.out.println("Ŀ¼ɾ��ʧ��");
				}
			}
		}
		
	}
}
