class Person
{
	private String name ;
	private int age ;
	/*
		����Ҫ�ṩһ���޲εĹ��췽�����˹��췽�����ڴ�ӡ����person�������Ϣ
		����Ҫ���ṩһ�����������ķ����������Ĭ��ֵΪ1�����˷���ҲҪ��ӡ���󴴽���Ϣ
		����Ҫ�����ṩһ�������������Ĺ��췽���������������������䣬��Ҫ��Ҳ��ӡ���󴴽���Ϣ
	*/
	public Person()
	{
		System.out.println("** ������һ��Person����") ;
	}
	public Person(String name)
	{
		System.out.println("** ������һ��Person����") ;
		this.setName(name) ;
		this.setAge(1) ;
	}
	public Person(String name,int age)
	{
		System.out.println("** ������һ��Person����") ;
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
	public int getAge()
	{
		return this.age ;
	}
	public String getName()
	{
		return this.name ;
	}
};
public class OODemo15
{
	public static void main(String args[])
	{
		Person per = new Person() ;
		per.setName("����") ;
		System.out.println(per.getName()) ;
	}
};

// 10  ˮƿ
// 0.1 ˮƿ