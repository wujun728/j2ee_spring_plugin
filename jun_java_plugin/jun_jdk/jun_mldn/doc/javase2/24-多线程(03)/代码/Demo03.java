class Person
{
	static
	{
		System.out.println("��̬��") ;
	}
	{
		System.out.println("����顣") ;
	}
	public Person()
	{
		System.out.println("���췽����") ;
	}
};
public class Demo03
{
	public static void main(String args[])
	{
		new Person() ;
		new Person() ;
	}
};