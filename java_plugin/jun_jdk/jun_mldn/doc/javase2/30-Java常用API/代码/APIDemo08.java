import java.util.* ;
import java.text.* ;
public class APIDemo08
{
	public static void main(String args[]) throws Exception
	{
		/*
			2007-5-17 16:19:20
			��-��-�� ʱ:��:��

		*/
		String str = "2007-5-17 16:19:20" ;
		// 1��׼��ԭ��ʽ
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;

		// 2��׼���¸�ʽ
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��") ;

		// 3����sdf1ģ��ժ��ʱ����
		/*
		public Date parse(String source)
           throws ParseException
		*/
		Date d = sdf1.parse(str) ;
		// 4����ʱ�������뵽��ģ��֮��
		// public final String format(Date date)
		String newStr = sdf2.format(d) ;
		System.out.println(newStr) ;
	}
};