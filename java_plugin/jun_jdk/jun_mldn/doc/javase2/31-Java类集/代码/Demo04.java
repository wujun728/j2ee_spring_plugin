import java.util.* ;
public class Demo04
{
	public static void main(String args[])
	{
		// ׼������һ��������������
		Set<java.lang.String> all = new HashSet<java.lang.String>() ; 
		// List<java.lang.String> all = new ArrayList<java.lang.String>() ; 
		// �򼯺��м�������
		all.add("MLDN") ;
		all.add("LXH") ;
		all.add("LXH") ;
		all.add("LXH") ;
		all.add("LXH") ;

		// ��ڶ���Ԫ�ش�����������
		all.add("www.mldn.cn") ;
		Iterator iter = all.iterator() ;
		while(iter.hasNext())
		{
			Object obj = iter.next() ;
			System.out.println(obj) ;
		}
	}
};