// ����һ��������
abstract class A
{
	public void fun2()
	{
		System.out.println("Hello World!!!") ;
	}
	public abstract void fun() ;
};
class B extends A	// B��һ����ͨ��
{
	// �����������Ҫ��д�������е�ȫ�����󷽷�
	public void fun()
	{
		System.out.println("��ӭ��ҹ���www.mldn.cn��") ;
	}
};
public class OODemo05
{
	public static void main(String args[])
	{
		B b = new B() ;
		b.fun() ;
		b.fun2() ;
	}
};