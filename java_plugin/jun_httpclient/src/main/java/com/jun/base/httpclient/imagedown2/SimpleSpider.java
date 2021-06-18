package com.jun.base.httpclient.imagedown2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SimpleSpider {
	// ��ʼҳ��
	private static final int page = 567364;

	public static void main(String[] args) {
		// HttpClient ��ʱ����
		RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD)
				.setConnectionRequestTimeout(6000).setConnectTimeout(6000).build();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
		System.out.println("5���ʼץȡ����ͼ����");
		for (int i = page; i > 0; i--) {
			// ����һ��GET����
//			HttpGet httpGet = new HttpGet("http://www.qiubaichengren.com/miss/"+i+".html");
//			HttpGet httpGet = new HttpGet("http://jandan.net/ooxx/page-" + i);
			HttpGet httpGet = new HttpGet("http://1024.91lulea.today/pw/htm_data/14/1703/"+ i+".html" );
			httpGet.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
			httpGet.addHeader("Cookie",
					"_gat=1; nsfw-click-load=off; gif-click-load=on; _ga=GA1.2.1861846600.1423061484");
			try {
				// ������̫��
				Thread.sleep(3000);
				// �������󣬲�ִ��
				CloseableHttpResponse response = httpClient.execute(httpGet);
				InputStream in = response.getEntity().getContent();
				String html = convertStreamToString(in);
				// ��ҳ���ݽ���
				new Thread(new JianDanHtmlParser(html, i)).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		StringBuilder sb = new StringBuilder();

		String line = null;

		try {

			while ((line = reader.readLine()) != null) {

				sb.append(line + "/n");

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				is.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		return sb.toString();

	}

}