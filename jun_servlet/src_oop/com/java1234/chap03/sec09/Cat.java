package com.java1234.chap03.sec09;

/**
 * �����Cat�࣬�̳���Animal
 * @author user
 *
 */
public class Cat extends Animal{

	private String address;
	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * �����޲ι��췽��
	 */
	public Cat(){
		super();
		System.out.println("�����޲ι��췽��");
	}
	
	/**
	 * �����в������췽��
	 * @param name
	 * @param age
	 */
	public Cat(String name,int age,String address){
		super(name,age);
		this.address=address;
		System.out.println("�����в������췽��");
	}
	
	
	/**
	 * ��д�����say����
	 */
	public void say(){
		super.say();
		System.out.println("����һֻè���ҽУ�"+this.getName()+",�ҵ������ǣ�"+this.getAge()+",�ҵĵ�ַ�ǣ�"+this.getAddress());
	}
	
	public static void main(String[] args) {
		Cat cat=new Cat("Mini",2,"����");
		/*cat.setName("Mini");
		cat.setAge(2);*/
		cat.say();
	}
}
