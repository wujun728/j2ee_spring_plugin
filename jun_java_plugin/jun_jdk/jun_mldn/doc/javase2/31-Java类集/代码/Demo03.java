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
public class Demo03
{
	public static void main(String args[])
	{
		// ׼������һ��������������
		List<java.lang.String> all = new ArrayList<java.lang.String>() ;
		// �򼯺��м�������
		all.add("MLDN") ;
		all.add("LXH") ;
		// all.add(new Person("��")) ;

		// ��ڶ���Ԫ�ش�����������
		all.add(1,"www.mldn.cn") ;
		Iterator iter = all.iterator() ;
		while(iter.hasNext())
		{
			Object obj = iter.next() ;
			System.out.println(obj) ;
		}
	}
};