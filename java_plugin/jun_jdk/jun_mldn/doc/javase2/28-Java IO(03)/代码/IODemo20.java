import java.io.* ;
public class IODemo20
{
	public static void main(String args[])
	{
		BufferedReader buf = null ;
		// �˴�ֻ��׼����Ҫ�Ӽ����ж�ȡ����
		buf = new BufferedReader(new InputStreamReader(System.in)) ;
		String str = null ;
		for(int i=0;i<2;i++)
		{
			try
			{
				System.out.print("���������ݣ�") ;
				str = buf.readLine() ;
			}
			catch (Exception e)
			{
			}
			System.out.println("���������Ϊ��"+str) ;
			System.out.println("--------------------------------") ;
		}
	}
};