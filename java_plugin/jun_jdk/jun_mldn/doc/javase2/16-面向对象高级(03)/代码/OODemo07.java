// ����һ��������
abstract class A
{
	private String info ;
	/*
	public A()
	{
		System.out.println("�������еĹ��췽����") ;
	}
	*/
	public A(String info)
	{
		this.info = info ;
		System.out.println("�������еĹ��췽����") ;
	}
	public void fun2()
	{
		System.out.println("info --> "+this.info) ;
	}
	public abstract void fun() ;
};
class B extends A
{
	public B(String info)
	{
		super(info) ;
	}
	public void fun()
	{
		System.out.println("��ӭ��ҹ���www.mldn.cn��") ;
	}
};
public class OODemo07
{
	public static void main(String args[])
	{
	}
};