class Person
{
	private String name ;
	private int age ;
	public Person(String name,int age)
	{
		this.name = name ;
		this.age = age ;
	}
	public boolean compare(Person p1)
	{
		boolean flag = false ;
		Person p2 = this ;
		if(p1.name.equals(p2.name)&&p1.age==p2.age)
		{
			flag = true ;
		}
		return flag ;
	}
	public void print()
	{
		System.out.println("������"+this.name) ;
		System.out.println("���䣺"+this.age) ;
	}
};
public class OODemo19
{
	public static void main(String args[])
	{
		// ������Ϊ�����ֺ�������ȵľ���ͬһ����
		Person per1 = new Person("����",30) ;
		Person per2 = new Person("����",31) ;
		System.out.println(per1.compare(per2)?"��ͬһ����":"����ͬһ����") ;
	}
};