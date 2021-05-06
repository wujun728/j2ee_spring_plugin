package com.itheima.web.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

//�ֶζ���˽�еģ��Ҷ���String���͡�  ��������ת��
//�ṩ��֤�ķ�������֤��ͬ�Ļ�����ʾ��Ϣ

//�ֶκͱ����ֶ���ȫһ��
public class UserFormBean {
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	//��װ������Ϣ��key���ֶΣ�value��������Ϣ
	private Map<String, String> errors = new HashMap<String, String>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	//����������֤������--js�ͷ������˶�д��
	public boolean validate(){
		//��֤�����ݲ�����Ҫ����errors������ֶκʹ�����ʾ
//		�û�����3~8����ĸ��ɣ�����Ϊ��<br/>
		if(username.trim().equals("")){
			errors.put("username", "�������û���");
		}else{
			if(!username.matches("[a-zA-Z]{3,8}")){
				errors.put("username", "�û���������3~8λ��ĸ���");
			}
		}
//  	���룺3~8λ������ɣ�����Ϊ��<br/>
		if(password.trim().equals("")){
			errors.put("password", "����������");
		}else{
			if(!password.matches("\\d{3,8}")){
				errors.put("password", "���������3~8λ�������");
			}
		}
//  	�ظ����룺���������һ��<br/>
		if(!password.equals(repassword)){
			errors.put("repassword", "�����������һ��");
		}
//  	���䣺����Ϊ�գ���Ҫ��������ĸ�ʽ<br/>
		if(email.trim().equals("")){
			errors.put("email", "����������");
		}else{
			if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){
				errors.put("email", "�����ʽ����ȷ");
			}
		}
//  	���գ�����Ϊ�գ���Ҫ����yyyy-MM-dd�ĸ�ʽ<br/>
		if(birthday.trim().equals("")){
			errors.put("birthday", "�������������");
		}else{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				df.parse(birthday);
			} catch (ParseException e) {
				errors.put("birthday", "���ڸ�ʽ���Ϸ�");
			}
		}
		return errors.isEmpty();
	}
}
