package com.itheima.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Client1 {

	public static void main(String[] args) {
		
		final SpringBrother sb = new SpringBrother();
		
		//����sb�Ĵ���
		/*
		Class type:������ĸ�����
		Callback cb:�ص�����δ���
		 */
		SpringBrother proxy = (SpringBrother) Enhancer.create(SpringBrother.class,new MethodInterceptor(){

			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy arg3) throws Throwable {
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
		});
		System.out.println(proxy instanceof SpringBrother);
		proxy.dance(100000);
		proxy.sing(50000);
		
	}

}
