public class OODemo10
{
	public static void main(String arg[])
	{
		try
		{
			// �����׳��ľ���һ���쳣��Ķ���
			throw new Exception("�Լ��׳���һ���쳣��") ;
		}
		catch (Exception e)
		{
			System.out.println(e) ;
		}
	}
};