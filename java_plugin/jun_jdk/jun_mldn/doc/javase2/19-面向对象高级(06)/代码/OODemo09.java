interface A
{
	public void fun() ;
}

// B��ֻʹ��һ�Σ��ǻ��б�Ҫ������
class B implements A
{
	public void fun() 
	{
		System.out.println("MLDN --> LXH") ;
	}
};
class C
{
	public void fun2()
	{
		this.print(new B()) ;
	}
	public void print(A a)
	{
		a.fun() ;
	}
};
public class OODemo09
{
	public static void main(String args[])
	{
		new C().fun2() ;
	}
};