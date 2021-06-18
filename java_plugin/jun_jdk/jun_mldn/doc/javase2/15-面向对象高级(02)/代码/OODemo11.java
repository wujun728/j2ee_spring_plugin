class Person
{
	// ����ƺ�һ��������Person��
	private String name ;
	private int age ;

	public Person(String name,int age)
	{
		this.setName(name) ;
		this.setAge(age) ;
	}

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
	public Student(String name,int age,String school)
	{
		super(name,age) ;
		this.setSchool(school) ;
	}
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
		return super.say()+"��ѧУ��"+this.school ;
	}
};
public class OODemo11
{
	public static void main(String args[])
	{
		Student s = new Student("����",30,"MLDN �˲���������") ;
		System.out.println(s.say()) ;
	}
};