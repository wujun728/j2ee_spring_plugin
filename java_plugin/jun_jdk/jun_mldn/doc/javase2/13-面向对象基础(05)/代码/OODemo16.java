class Person
{
	// ��̬�����
	static
	{
		System.out.println("static code() ...") ;
	}
	// �����
	{
		System.out.println("Hello World!!!") ;
	}
	// ����һ�����췽��
	Person()
	{
		System.out.println("Person()���췽��") ;
	}
};
public class OODemo16
{
	public static void main(String args[])
	{
		new Person() ;
		new Person() ;
	}
};