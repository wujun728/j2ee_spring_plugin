class Person
{
	String name ;
	int age ;
	public Person(String name,int age)
	{
		this.name = name ;
		this.age = age ;
	}
	public void print()
	{
		System.out.println("print�����еģ�"+this) ;
	}
};
public class OODemo17
{
	public static void main(String args[])
	{
		Person p = new Person("����",30) ;
		System.out.println("main�����еģ�"+p) ;
		p.print() ;
		System.out.println("------------------------") ;
		Person p1 = new Person("����",33) ;
		System.out.println("main�����еģ�"+p1) ;
		p1.print() ;
	}
};