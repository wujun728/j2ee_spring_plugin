import java.util.* ;
class Person
{
	private String name ;
	public Person(String name)
	{
		this.name = name ;
	}
	public String toString()
	{
		return "������"+this.name ;
	}
};
public class Demo01
{
	public static void main(String args[])
	{
		// ׼������һ��������������
		List all = new ArrayList() ;
		// �򼯺��м�������
		all.add("MLDN") ;
		all.add("LXH") ;
		all.add(new Person("��")) ;

		// ��ڶ���Ԫ�ش�����������
		all.add(1,"www.mldn.cn") ;
		// all.remove(1) ;
		for(int i=0;i<all.size();i++)
		{
			System.out.println(all.get(i)) ;
		}
	}
};