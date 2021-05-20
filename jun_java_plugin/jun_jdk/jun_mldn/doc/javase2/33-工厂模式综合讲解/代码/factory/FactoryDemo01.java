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
class Factory
{
	public static Fruit getFruitInstance()
	{
		return new Orange() ;
	}
};
public class FactoryDemo01
{
	public static void main(String args[])
	{
		Fruit f = Factory.getFruitInstance() ;
		f.grow() ;
		f.pick() ;
	}
};