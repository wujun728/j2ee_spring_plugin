package com.java1234.chap10.sec02;

import java.io.File;
import java.io.IOException;

public class Demo4 {

	public static void listFile(File file){
		if(file!=null){
			if(file.isDirectory()){ // ��Ŀ¼���
				System.out.println(file); // ��ӡĿ¼
				File files[]=file.listFiles(); // ����Ŀ¼
				if(files!=null){
					for(int i=0;i<files.length;i++){
						listFile(files[i]); // �ݹ��������
					}
				}
			}else{ // ���ļ����
				System.out.println(file); // ���ļ� ֱ�Ӵ�ӡ�ļ���·��
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		File file=new File("C://apache-tomcat-7.0.63");
		listFile(file);
	}
}
