interface A
{
	// ���峣��
	// public static final String INFO = "LXH" ;
	String INFO = "LXH" ;
	// public abstract void say() ;
	public void say() ;
}
interface B 
{
	String MURL = "www.MLDN.cn" ;
	public void hello() ;
}
abstract class C
{
	public abstract void fun() ;
};
class X extends C implements A,B
{
	// ����Ҫʵ�ֽӿ���ȫ���ĳ��󷽷�
	public void say()
	{
		System.out.println("��Ϣ�ǣ�"+INFO) ;
		System.out.println("MURL�ǣ�"+MURL) ;
	}
	public void hello()
	{
		System.out.println("B�ӿ��е����ݣ�"+MURL) ;
	}
	public void fun()
	{
		say() ;
		hello() ;
	}
};
public class OODemo12
{
	public static void main(String args[])
	{
		X x = new X() ;
		// x.say() ;
		// x.hello() ;
		x.fun() ;
	}
};