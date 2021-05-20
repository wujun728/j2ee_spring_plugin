class Person{
	private String name ;
	private int age ;
	public Person(String name,int age){
		this.name = name ;
		this.age = age ;
	}
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
	public String getInfo(){
		return "������" + this.name + "�����䣺" + this.age ;
	}
};
class Student extends Person {
	private String school ;	// ���������
	public Student(String name,int age,String school){
		this(name,age) ;	// ��ȷ���ø����������������Ĺ��췽��
		this.school = school ;
	}
	public Student(String name,int age){
		super(name,age) ;
	}
	public String getInfo(){
		return super.getInfo() + "��ѧУ��" + this.school ;
	}
	public void setSchool(String school){
		this.school = school ;
	}
	public String getSchool(){
		return this.school ;
	}
};
public class ExtDemo10{
	public static void main(String args[]){
		Student stu = new Student("����",30,"�廪��ѧ") ;	//  ѧ��
		System.out.println(stu.getInfo()) ;
	}
};