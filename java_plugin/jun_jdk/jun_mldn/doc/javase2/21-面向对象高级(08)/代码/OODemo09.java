class MathDemo
{
	// �˷�����û�п��ܷ����쳣��
	public int div(int i,int j) throws Exception
	{
		return i / j ;
	}
};

public class OODemo09
{
	public static void main(String arg[]) throws Exception
	{
		System.out.println(new MathDemo().div(10,0)) ;
	}
};