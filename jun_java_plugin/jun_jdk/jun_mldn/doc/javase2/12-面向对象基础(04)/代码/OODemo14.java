class Person
{
	private String name ;
	private int age ;
	public void setName(String name)
	{
		// ǿ��һ�£����ñ����е�print����
		this.print() ;
		this.name = name ;
	}
	public String getName()
	{
		return this.name ;
	}
	public void print()
	{
		System.out.println("���������ˡ�") ;
	}
};
public class OODemo14
{
	public static void main(String args[])
	{
		Person per = new Person() ;
		per.setName("����") ;
		System.out.println(per.getName()) ;
	}
};

// 10  ˮƿ
// 0.1 ˮƿ