class A
{
	public A()
	{
		System.out.println("1��public A(){}") ;
	}
};
class B extends A
{
	public B()
	{
		// �˴�������һ�δ���
		super() ;
		System.out.println("2��public B(){}") ;
	}
};
public class OODemo06
{
	public static void main(String args[])
	{
		B b = new B() ;
	}
};