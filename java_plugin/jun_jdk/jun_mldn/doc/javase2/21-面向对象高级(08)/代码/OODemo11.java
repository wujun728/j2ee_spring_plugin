class MathDemo
{
	// �˷�����û�п��ܷ����쳣��
	public int div(int i,int j) throws Exception
	{
		if(j==0)
		{
			throw new Exception("����������Ϊ�㡣") ;
		}
		return i / j ;
	}
};

public class OODemo11
{
	public static void main(String arg[])
	{
		try
		{
			System.out.println(new MathDemo().div(10,0)) ;
		}
		catch (Exception e)
		{
			System.out.println(e) ;
		}
	}
};