import java.util.* ;
// Ҳ��һ����ʶ�ӿ�
class Person implements Cloneable
{
	String name ;
	int age ;
	public Person(String name,int age)
	{
		this.name = name ;
		this.age = age ;
	}
	public String toString()
	{
		return "������"+this.name+"�����䣺"+this.age ;
	}
	public Object clone()
                throws CloneNotSupportedException
	{
		return super.clone() ;
	}
};
public class AdvDemo03
{
	public static void main(String args[]) throws Exception
	{
		Person p1 = new Person("����",30) ;
		Person p2 = (Person)p1.clone() ;
		p2.name = "����" ;
		System.out.println(p1) ;
		System.out.println(p2) ;
	}
};