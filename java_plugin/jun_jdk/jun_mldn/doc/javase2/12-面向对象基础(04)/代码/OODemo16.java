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
		// ���ñ����е��޲ι��췽��
		this() ;
		this.setName(name) ;
		this.setAge(1) ;
	}
	public Person(String name,int age)
	{
		this(name) ;
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
public class OODemo16
{
	public static void main(String args[])
	{
		Person per = new Person("����",30) ;
	}
};