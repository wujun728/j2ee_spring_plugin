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
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person))
		{
			return false ;
		}
		Person per1 = this ;
		Person per2 = (Person)obj ;
		boolean flag = false ;
		if(per1==per2)
		{
			// �ж��Ƿ���ͬһ������
			flag = true ;
		}
		else
		{
			if(per1.name.equals(per2.name)&&per1.age==per2.age)
			{
				flag = true ;
			}
		}
		return flag ;
	}
	public String toString()
	{
		return "������"+this.name+"�����䣺"+this.age ;
	}
};
public class OODemo04
{
	public static void main(String args[])
	{
		Person p1 = new Person("LXH",30) ;
		// Person p2 = new Person("LXH",30) ;
		Person p2 = p1 ;
		System.out.println(p1.equals("abc")) ;
	}
};