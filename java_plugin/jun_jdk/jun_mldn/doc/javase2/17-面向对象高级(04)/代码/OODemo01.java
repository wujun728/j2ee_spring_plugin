// ��ʾ��������ʹ����ͨ��
class A
{
	public void fun1()
	{
		System.out.println("1��A --> public void fun1()") ;
	}
	public void fun2()
	{
		this.fun1() ;
	}
};
class B extends A
{
	// ��д��fun1()����
	public void fun1()
	{
		System.out.println("2��B --> public void fun1()") ;
	}
	// ������һ��fun3()����
	public void fun3()
	{
		System.out.println("3��B --> public void fun3()") ;
	}
};
public class OODemo01
{
	public static void main(String args[])
	{
		A a = null ;
		a = new B() ;
		// �������Ϊ����ʵ����
		// fun1���������าд��
		// B b = null ;
		// b = (B)a ;
		a.fun2() ;
		a.fun3() ;
		// b.fun2() ;
	}
};