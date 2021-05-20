package com.open1111.httpclient.chap05;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo1 {

	public static void main(String[] args)throws Exception {
		CloseableHttpClient httpClient=HttpClients.createDefault(); // ����httpClientʵ��
		HttpGet httpGet=new HttpGet("http://central.maven.org/maven2/"); // ����httpgetʵ��
		RequestConfig config=RequestConfig.custom()
				.setConnectTimeout(10000) // �������ӳ�ʱʱ�� 10����
				.setSocketTimeout(20000) // ���ö�ȡ��ʱʱ��10����
				.build();
		httpGet.setConfig(config);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		CloseableHttpResponse response=httpClient.execute(httpGet); // ִ��http get����
		HttpEntity entity=response.getEntity(); // ��ȡ����ʵ��
		System.out.println("��ҳ���ݣ�"+EntityUtils.toString(entity, "utf-8")); // ��ȡ��ҳ����
		response.close(); // response�ر�
		httpClient.close(); // httpClient�ر�
	}
}
