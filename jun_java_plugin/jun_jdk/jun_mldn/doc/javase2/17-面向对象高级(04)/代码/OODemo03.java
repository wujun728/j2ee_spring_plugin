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
class C extends A
{
	// ��д��fun1()����
	public void fun1()
	{
		System.out.println("4��C --> public void fun1()") ;
	}
	// ������һ��fun3()����
	public void fun4()
	{
		System.out.println("5��C --> public void fun4()") ;
	}
};
public class OODemo03
{
	public static void main(String args[])
	{
		// ����̬�Ե��׸���ô�ã�
		// һ��print�������˷������Խ���A��B��Ķ��󣬲����÷�����ӡ
		// �����A����������fun2()����
		// �����B����������fun2()��fun3()��������
		print(new C()) ;
		// ���A�໹��20�����࣬����ô����
		// ��˷�����Ҫ��д20��
	}
	public static void print(A a)
	{
		a.fun2() ;
		// ȱ��һ�������Ƿ���ĳһ�����ʵ�����ж�
		if(a instanceof B)
		{
			B b = (B)a ;
			b.fun3() ;
		}
		if(a instanceof C)
		{
			C c = (C)a ;
			c.fun4() ;
		}
	}
	/*
	public static void print(B b)
	{
		b.fun2() ;
		b.fun3() ;
	}
	*/
};