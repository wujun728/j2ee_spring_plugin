public class JavaDemo06
{
	public static void main(String args[])
	{
		int i = 20 ;
		int j = 50 ;
		// ��i ��j �е����ֵ��ֵ��max
		int max = 0 ;
		/*
		if(i>j)
		{
			max = i ;
		}
		else
		{
			max = j ;
		}
		*/
		max = i>j?i:j ;
		System.out.println("���ֵ MAX = "+max) ;
	}
};