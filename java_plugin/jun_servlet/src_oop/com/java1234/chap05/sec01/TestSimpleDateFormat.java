package com.java1234.chap05.sec01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {

	/**
	 * �������ַ���ת����һ�����ڶ���
	 * @param dateStr �����ַ���
	 * @param format ��ʽ
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDateStr(String dateStr,String format) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.parse(dateStr);
	}
	
	
	/**
	 * �����ڶ����ʽ��Ϊָ����ʽ�������ַ���
	 * @param date ��������ڶ���
	 * @param format ��ʽ
	 * @return
	 */
	public static String formatDate(Date date,String format){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	
	public static void main(String[] args) throws ParseException {
		Date date=new Date();
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));*/
		
		System.out.println(formatDate(date,"yyyy-MM-dd"));
		System.out.println(formatDate(date,"yyyy-MM-dd HH:mm:ss"));
		System.out.println(formatDate(date,"yyyy��MM��dd�� HHʱmm��ss��"));
		
		String dateStr="1989-11-02 10:04:07";
		Date date2=formatDateStr(dateStr,"yyyy-MM-dd HH:mm:ss");
		System.out.println(formatDate(date2,"yyyy-MM-dd HH:mm:ss"));
	}
}
