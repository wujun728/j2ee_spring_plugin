package com.open1111.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloWorld {

	public static void main(String[] args) {
		CloseableHttpClient httpClient=HttpClients.createDefault(); // ����httpClientʵ��
		HttpGet httpGet=new HttpGet("http://www.tuicool.com/"); // ����httpgetʵ��
		CloseableHttpResponse response=null;
		try {
			response=httpClient.execute(httpGet); // ִ��http get����
		} catch (ClientProtocolException e) { // httpЭ���쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { // io�쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		HttpEntity entity=response.getEntity(); // ��ȡ����ʵ��
		try {
			System.out.println("��ҳ���ݣ�"+EntityUtils.toString(entity, "utf-8")); // ��ȡ��ҳ����
		} catch (ParseException e) { // �����쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { // io�쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			response.close(); // response�ر�
		} catch (IOException e) {  // io�쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			httpClient.close(); // httpClient�ر�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
