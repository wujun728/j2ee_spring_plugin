package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client1 {

	public static void main(String[] args) {
		final Human sb = new SpringBrother();
		
		//������:��ζ�̬����������
		
		/*
		ClassLoader loader:��̬�����������ֽ���class���ӵ��ڴ������У�����������������̶����ͱ��������õ���һ����
        Class<?>[] interfaces:������Ҫʵ�ֵĽӿڣ�Ҫ�ͱ��������������ͬ����Ϊ���̶����ͱ��������õ���һ����
        InvocationHandler h:��δ�������һ���ӿڡ��������ģʽ��
        
		 */
		//���������࣬�õ�����ʵ��
		Human proxyMan = (Human)Proxy.newProxyInstance(sb.getClass().getClassLoader(), 
				sb.getClass().getInterfaces(), 
				new InvocationHandler() {
					//�����ڲ��࣬��ɾ���Ĵ������
					//���ô�������κη��������ᾭ���÷�����  ����
			
					/*
					 Object proxy:�Դ����������á�
					 Method method:��ǰִ�еķ���
					 Object[] args:��ǰ�����õ��Ĳ���
					 
					 
					 ����ֵ����ǰ���õķ����ķ���ֵ
					 */
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						//�жϳ�����
						if("sing".equals(method.getName())){
							//����
							float money = (Float)args[0];
							if(money>10000){
								method.invoke(sb, money/2);
							}
						}
						if("dance".equals(method.getName())){
							//����
							float money = (Float)args[0];
							if(money>20000){
								method.invoke(sb, money/2);
							}
						}
						return null;
					}
				}
		);
		proxyMan.sing(20000);
		proxyMan.dance(100000);
	}

}
