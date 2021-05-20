import java.util.* ;
class Person implements Comparable
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
	// ��дcompareTo���������������
	public int compareTo(Object obj)
	{
		Person p = (Person)obj ;
		if(p.score>this.score)
		{
			return 1 ;
		}
		else if(p.score<this.score)
		{
			return -1 ;
		}
		else
		{
			// ����ɼ�������ж�����
			if(p.age>this.age)
			{
				return 1 ;
			}
			else if(p.age<this.age)
			{
				return -1 ;
			}
			else
			{
				return 0 ;
			}
		}
	}
};
public class AdvDemo06
{
	public static void main(String args[])
	{
		Set s = new TreeSet() ;
		s.add(new Person("����",20,96)) ;
		s.add(new Person("����",19,96)) ;
		s.add(new Person("����",19,97)) ;
		s.add(new Person("����",21,78)) ;
		s.add(new Person("����",20,80)) ;
		Iterator iter = s.iterator() ;
		while(iter.hasNext())
		{
			System.out.println(iter.next()) ;
		}
	}
};