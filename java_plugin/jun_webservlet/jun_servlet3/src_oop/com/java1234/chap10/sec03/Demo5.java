package com.java1234.chap10.sec03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Demo5 {

	public static void main(String[] args) throws Exception {
		File file=new File("C://�����ļ�.txt");
		OutputStream out=new FileOutputStream(file,true);
		String str="��ã��Һã���Һ� �������������322�ð�";
		byte b[]=str.getBytes();
		out.write(b);
		out.close();
	}
}
