package org.lxh.demo ;
interface Fruit
{
	// ����
	public void grow() ;
	// ��ժ
	public void pick() ;
}
class Apple implements Fruit
{
	public void grow()
	{
		System.out.println("ƻ�������������� ") ;
	}
	public void pick()
	{
		System.out.println("ժƻ��������") ;
	}
};
class Orange implements Fruit
{
	public void grow()
	{
		System.out.println("���������������� ") ;
	}
	public void pick()
	{
		System.out.println("ժ���ӡ�����") ;
	}
};
class Cherry implements Fruit
{
	public void grow()
	{
		System.out.println("ӣ�������������� ") ;
	}
	public void pick()
	{
		System.out.println("ժӣ�ҡ�����") ;
	}
};
class Factory
{
	public static Fruit getFruitInstance(String type)
	{
		Fruit f = null ;
		if("Apple".equals(type))
		{
			f = new Apple() ;
		}
		if("Orange".equals(type))
		{
			f = new Orange() ;
		}
		if("Cherry".equals(type))
		{
			f = new Cherry() ;
		}
		return f ;
	}
};
public class FactoryDemo03
{
	public static void main(String args[])
	{
		if(args.length==0)
		{
			System.out.println("��������һ��Ҫʹ�õ�����") ;
			System.exit(1) ;
		}
		Fruit f = Factory.getFruitInstance(args[0]) ;
		if(f!=null)
		{
			f.grow() ;
			f.pick() ;
		}
		else
		{
			System.out.println("û�з���������͡�") ;
		}
	}
};