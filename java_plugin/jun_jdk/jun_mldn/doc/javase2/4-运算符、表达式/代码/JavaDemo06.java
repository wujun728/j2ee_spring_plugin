public class JavaDemo06
{
	public static void main(String args[])
	{
		// ѧ����ѧ��������5~7��֮��
		// ����ɼ���90�֣�����������7�꣬���ʾ��һ��ѧ��
		int age = 6 ;
		int score = 90 ;
		// 5<=age>=7 : age>=5 age<=7
		// boolean flag = age>=5&&age<=7 ;
		boolean flag = age==7 | score==90 ;
		System.out.println(flag) ;
	}
};
