import java.util.* ;
class Person
{
	private String name ;
	private int age ;
	private float score ;
	public Person(String name,int age,float score)
	{
		this.name = name ;
		this.age = age ;
		this.score = score ;
	}
	public String toString()
	{
		return "������"+this.name+"�����䣺"+this.age+"���ɼ���"+this.score ;
	}
};
public class AdvDemo07
{
	public static void main(String args[])
	{
		Person p = new Person("����",30,89) ;
		System.out.println(p.getClass().getName()) ;
	}
};