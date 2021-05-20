package com.open1111.httpclient.chap04;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo01 {

	public static void main(String[] args)throws Exception {
		CloseableHttpClient httpClient=HttpClients.createDefault(); // ����httpClientʵ��
		HttpGet httpGet=new HttpGet("http://www.tuicool.com/"); // ����httpgetʵ��
		HttpHost proxy=new HttpHost("175.155.213.235", 9999);
		RequestConfig config=RequestConfig.custom().setProxy(proxy).build();
		httpGet.setConfig(config);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		CloseableHttpResponse response=httpClient.execute(httpGet); // ִ��http get����
		HttpEntity entity=response.getEntity(); // ��ȡ����ʵ��
		System.out.println("��ҳ���ݣ�"+EntityUtils.toString(entity, "utf-8")); // ��ȡ��ҳ����
		response.close(); // response�ر�
		httpClient.close(); // httpClient�ر�
	}
}
