class Person{
	private String name ;
	private int age ;
	public void setName(String name){
		this.name = name ;
	}
	public void setAge(int age){
		this.age = age ;
	}
	public String getName(){
		return this.name ;
	}
	public int getAge(){
		return this.age ;
	}
};
class Student extends Person {
	private String school ;	// ���������
	public void setSchool(String school){
		this.school = school ;
	}
	public String getSchool(){
		return this.school ;
	}
};
public class ExtDemo03{
	public static void main(String args[]){
		Student stu = new Student() ;	//  ѧ��
		stu.setName("����") ;	// ��Person�̳ж���
		stu.setAge(30) ;		// ��Person�̳ж���
		stu.setSchool("�廪��ѧ") ;		// �Լ�����ķ���
		System.out.println("������" + stu.getName()) ;
		System.out.println("���䣺" + stu.getAge()) ;
		System.out.println("ѧУ��" + stu.getSchool()) ;
	}
};