class Person
{
	// private����������ֻ���ڱ��࿴��
	// ����
	private String name ;
	// ����
	private int age ;

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
public class OODemo05
{
	public static void main(String args[])
	{
		Person lxh1 = new Person() ;
		lxh1.setName("���˻�") ;
		// ���߼��϶��Դ����Ѿ��Ǵ����
		lxh1.setAge(30) ;
		System.out.println(lxh1.shout()) ;
	}
};