class Person
{
	// private����������ֻ���ڱ��࿴��
	// ����
	private String name ;
	// ����
	private int age ;
	Person()
	{}
	// ����һ�����췽��
	Person(String n,int a)
	{
		// Ϊ���е����Գ�ʼ��
		this.setName(n) ; 
		this.setAge(a) ;
		System.out.println("** ���췽��������...") ;
	}

	// ����һϵ�е�setter��getter����
	public void setName(String n)
	{
		name = n ;
	}
	public void setAge(int a)
	{
		if(a>0&&a<150)
		{
			age = a ;
		}
		else
		{
			age = -1 ;
		}
	}
	public String getName()
	{
		return name ;
	}
	public int getAge()
	{
		return age ;
	}

	public String shout()
	{
		return "������"+this.name+"\n���䣺"+this.age ;
	}
};
// Ҫʹ������Ҫͨ������
public class OODemo06
{
	public static void main(String args[])
	{
		// Person lxh1 = new Person("���˻�",-30) ;
		Person lxh1 = new Person() ;
		lxh1.setName("���˻�") ;
		// ���߼��϶��Դ����Ѿ��Ǵ����
		lxh1.setAge(30) ;
		System.out.println(lxh1.shout()) ;
	}
};