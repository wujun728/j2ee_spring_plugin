// Object����������ĸ��࣬���һ����û����ȷ�����̳����Ǹ���
// ��϶���̳�Object��
class Person// extends Object
{
	private String name ;
	private int age ;
	public Person(String name,int age)
	{
		this.name = name ;
		this.age = age ;
	}
	public String toString()
	{
		return "������"+this.name+"�����䣺"+this.age ;
	}
};
public class OODemo03
{
	public static void main(String args[])
	{
		Person p1 = new Person("LXH",30) ;
		Person p2 = new Person("LXH",30) ;
		System.out.println(p1.equals(p2)) ;
	}
};