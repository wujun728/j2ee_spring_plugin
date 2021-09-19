package com.tanzhou.getIP;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ��ȡ ����IP
 * @author Tony Liu
 * 
 * 1����ȡ���ص�IP��ַ
 * 2����ȡ�����ķ���������
 * 3����ȡԶ�̷�����������IP��ַ
 * 4����ȡԶ�̷���������������IP
 *
 * �����̣�
 * InetAddress ��������װIP��ַ�����Ϣ����
 * 
 * 1��getLocalHost()  Ϊ������������IP����
 *   getByName(host)  ����������ȡ������������ַ����
 *   getAllByName(host) Ϊָ����һ��ͬ������������һ��InetAddress��������
 */
public class TestGetIP {
  
	 /*
	  * ��ȡ��������IP��ַ
	  */
	public static void getLocalIP(){
		// ������������IP��ַ����
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String hostAddr = addr.getHostAddress();// ��ȡIP��ַ
			String hostName = addr.getHostName(); // ��ȡ���ػ�����
			
			System.out.println("����IP��ַ��"+hostAddr);
			System.out.println("���صĻ������ƣ�"+hostName);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ����������ȡ������������IP
	 * @param hostName  ����
	 */
	public static void getIPByName(String hostName){
		
		try {
			// ������������������ַ����
			InetAddress addr = InetAddress.getByName(hostName);
			// ��ȡ����IP
			String hostAddr = addr.getHostAddress(); // ��ȡ����IP��ַ
			System.out.println("����Ϊ��"+hostName+"������IP��ַ��"+hostAddr);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ������������������е�IP��ַ
	 * @param hostName ����
	 */
	public static void getAllIPByName(String hostName){
		try {
			InetAddress[] addrs = InetAddress.getAllByName(hostName);
			String[] ips = new String[addrs.length];
			System.out.println("����Ϊ��"+hostName+"���������е�IP��ַΪ��");
			for(int i=0;i<addrs.length;i++){
				ips[i] = addrs[i].getHostAddress();
				System.out.println(ips[i]);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		String hsotName = "www.taobao.com";
		
		getLocalIP();
		getIPByName(hsotName);
		getAllIPByName(hsotName);
	}
	
}
