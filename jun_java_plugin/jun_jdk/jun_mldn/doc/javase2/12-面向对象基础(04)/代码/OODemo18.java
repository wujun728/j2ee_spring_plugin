class Person
{
	private String name ;
	private int age ;
	public Person(String name,int age)
	{
		this.name = name ;
		this.age = age ;
	}
	public void change(Person p)
	{
		p.name = "����" ;
		p.age = 50 ;
	}
	public void print()
	{
		System.out.println("������"+this.name) ;
		System.out.println("���䣺"+this.age) ;
	}
};
public class OODemo18
{
	public static void main(String args[])
	{
		Person p = new Person("����",30) ;
		p.change(p) ;
		p.print() ;
	}
};