public class APIDemo02
{
	public static void main(String args[])
	{
		// String str = "" ;
		// ��+��ʾ�ַ�������
		// str = "A" + "B" + "c" ;
		StringBuffer sb = new StringBuffer() ;
		sb.append("A").append("B") ;
		sb.append("C").append(1) ;
		fun(sb) ;
		System.out.println(sb) ;
	}
	// StringBuffer���ݵ�������
	public static void fun(StringBuffer s)
	{
		s.append("LXH --> MLDN") ;
	}
};