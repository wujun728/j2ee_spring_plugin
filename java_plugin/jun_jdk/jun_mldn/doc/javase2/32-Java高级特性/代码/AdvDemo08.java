import java.util.* ;
public class AdvDemo08
{
	public static void main(String args[]) throws Exception
	{
		// ͨ��������֤
		List all = null ;

		// all = new ArrayList() ;
		// �����ַ����ҵ�һ����
		Class c = Class.forName("java.util.ArrayList") ;
		all = (List)c.newInstance() ;
		all.add("A") ;
		all.add("B") ;
		all.add("C") ;

		System.out.println(all) ;
	}
};