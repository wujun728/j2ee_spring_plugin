package com.tanzhou.demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
/**
 * ��java�������ַ�ʽʵ�ֶ��̣߳�һ���Ǽ̳� Thread�࣬һ����ʵ��Runnable�ӿڣ�
 * @author Administrator
 *
 *��ʵ�ʵĿ����пɶ�����Runnable�ӿ�Ϊ��
 *
 *1��������  2�����ƽ��棨��ʾ��̬ʱ�䣩 3�������߳�ˢ�½���
 */


public class Demo extends JFrame implements Runnable{
	Thread clock; 
	public Demo(){
		super("����ʱ��"); // ���ø���Ĺ��캯��
		
		setFont(new Font("Times",Font.BOLD,60)); // ��ʾ����ʱ�ӵ�����
		start();
		setSize(300,100);// ���ý����С
		setVisible(true); // ���ڿ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �رմ��ڵ�ʱ���˳�����
	}
	
	public void start(){ //��ʼ
		if(clock==null){
			clock = new Thread(this); // ʵ��������
			// jdk�ṩ һ������start���������ͨ��JVM�ҵ�run()����
			clock.start(); // ��ʼ����
		}
	}
	
	// ���н���
	public void run() { 
		while(clock!=null){
			repaint(); // �ػ����
			try {
				Thread.sleep(1000); // �߳���ͣ1000����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g){ // ��д�����paint����
		Graphics2D g2 = (Graphics2D)g; 
		Calendar now = new GregorianCalendar(); // �ṩ������ϵͳ
		String timeInfo = "";
		
		int hour = now.get(Calendar.HOUR_OF_DAY); //�õ�Сʱ
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		if(hour<=9){
			timeInfo+="0"+hour+":";
		}else{
			timeInfo+=hour+":";
		}
		
		if(minute<=9){
			timeInfo+="0"+minute+":";
		}else{
			timeInfo+=minute+":";
		}
		
		if(second<=9){
			timeInfo+="0"+second;
		}else{
			timeInfo+=second;
		}
		g.setColor(Color.white); // ������ɫ ��ɫ
		Dimension dim = getSize(); // �õ����ڴ�С
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.orange); // ��ɫ
		g.drawString(timeInfo, 20, 80);
	}
	// ��������
	public static void main(String[] args){
		new Demo();
	}
}
