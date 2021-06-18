package com.demo.spring.rpc.service;

import java.util.List;

import com.demo.spring.rpc.service.Student;

/**
 * ҵ��ӿ�
 */
public interface WelcomeService {
	public void sayHello(String name);
	public int getLength(String name);
	public List<Student> getStudents(int n);
}
