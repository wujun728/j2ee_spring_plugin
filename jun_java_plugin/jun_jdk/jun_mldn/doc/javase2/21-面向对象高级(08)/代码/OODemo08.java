class MathDemo
{
	// �˷�����û�п��ܷ����쳣��
	public int div(int i,int j) throws Exception
	{
		return i / j ;
	}
};

public class OODemo08
{
	public static void main(String arg[])
	{
		try
		{
			System.out.println(new MathDemo().div(10,10)) ;
		}
		catch (Exception e)
		{
			System.out.println(e) ;
		}
	}
};