public class JavaDemo03
{
	public static void main(String args[])
	{
		// ������һ������
		int i[] = null ;
		// ʹ�����飿
		i = new int[10] ;
		// i[0]  ~ i[9]
		
		for (int x=0;x<10;x++)
		{
			i[x] = x * x ;
		}
		System.out.println("--------- �ı�֮ǰ------------------") ;
		for (int x=0;x<10;x++)
		{
			System.out.println("i["+x+"] = "+i[x]) ;
		}
		// Ϊ���ٵĶ��ڴ�ռ�����һ������
		int y[] = i ;
		// ��y�е����ݽ����޸�
		for (int x=0;x<10;x++)
		{
			y[x] = x + 1 ;
		}
		System.out.println("--------- �ı�֮��------------------") ;
		for (int x=0;x<10;x++)
		{
			System.out.println("i["+x+"] = "+i[x]) ;
		}
	}
};