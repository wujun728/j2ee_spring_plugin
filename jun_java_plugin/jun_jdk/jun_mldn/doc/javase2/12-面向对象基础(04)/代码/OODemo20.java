class Person
{
	private String name ;
	private int age ;
	public Person(String name,int age)
	{
		this.name = name ;
		this.age = age ;
	}
	public void print()
	{
		System.out.println("������"+this.name) ;
		System.out.println("���䣺"+this.age) ;
	}
};
public class OODemo20
{
	public static void main(String args[])
	{
		// �������飺������ ����������[] = null ;
		// ���������� = new ������[] 
		Person p[] = null ;
		p = new Person[10] ;
		// ����������ʹ��ʱ��ҪΪÿһ��Ԫ��[����]�ֱ�ʵ����
		p[0] = new Person("����",30) ;
		p[1] = new Person("����1",33) ;
		p[2] = new Person("����2",33) ;
		p[3] = new Person("����3",33) ;
		p[4] = new Person("����4",33) ;
		p[5] = new Person("����5",33) ;
		p[6] = new Person("����6",33) ;
		p[7] = new Person("����7",33) ;
		p[8] = new Person("����8",33) ;
		p[9] = new Person("����9",33) ;
		for(int i=0;i<p.length;i++)
		{
			p[i].print() ;
			System.out.println("-----------------------------") ;
		}
	}
};