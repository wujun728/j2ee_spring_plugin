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

class Student
{
	private String name ;
	private int age ;
	private String school ;
	public void setName(String name)
	{
		this.name = name ;
	}
	public void setAge(int age)
	{
		this.age = age ;
	}
	public void setSchool(String school)
	{
		this.school = school ;
	}
	public String getName()
	{
		return this.name ;
	}
	public int getAge()
	{
		return this.age ;
	}
	public int getSchool()
	{
		return this.school ;
	}
	public String say()
	{
		return "������"+this.name+"�����䣺"+this.age+"��ѧУ��"+this.school ;
	}
};