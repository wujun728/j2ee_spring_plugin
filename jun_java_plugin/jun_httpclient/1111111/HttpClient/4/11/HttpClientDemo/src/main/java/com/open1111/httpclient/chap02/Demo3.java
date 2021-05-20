package com.open1111.httpclient.chap02;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo3 {

	public static void main(String[] args)throws Exception {
		CloseableHttpClient httpClient=HttpClients.createDefault(); // ����httpClientʵ��
		HttpGet httpGet=new HttpGet("http://www.open1111.com/"); // ����httpgetʵ��
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		CloseableHttpResponse response=httpClient.execute(httpGet); // ִ��http get����
		System.out.println("Status:"+response.getStatusLine().getStatusCode());
		HttpEntity entity=response.getEntity(); // ��ȡ����ʵ��
		System.out.println("Content-Type:"+entity.getContentType().getValue());
		//System.out.println("��ҳ���ݣ�"+EntityUtils.toString(entity, "utf-8")); // ��ȡ��ҳ����
		response.close(); // response�ر�
		httpClient.close(); // httpClient�ر�
	}
}
