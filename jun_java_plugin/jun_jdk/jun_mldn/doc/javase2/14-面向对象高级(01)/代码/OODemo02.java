class Person
{
	private String name ;
	private int age ;
	public void setName(String name)
	{
		this.name = name ;
	}
	public void setAge(int age)
	{
		this.age = age ;
	}
	public String getName()
	{
		return this.name ;
	}
	public int getAge()
	{
		return this.age ;
	}
	public String say()
	{
		return "������"+this.name+"�����䣺"+this.age ;
	}
};

class Student extends Person
{
	private String school ;
	public void setSchool(String school)
	{
		this.school = school ;
	}
	public String getSchool()
	{
		return this.school ;
	}
	public String say()
	{
		return "������"+this.getName()+"�����䣺"+this.getAge()+"��ѧУ��"+this.school ;
	}
};
public class OODemo02
{
	public static void main(String args[])
	{
		Student s = new Student() ;
		s.setName("����") ;
		s.setAge(30) ;
		s.setSchool("MLDN �˲���������") ;
		System.out.println(s.say()) ;
	}
};