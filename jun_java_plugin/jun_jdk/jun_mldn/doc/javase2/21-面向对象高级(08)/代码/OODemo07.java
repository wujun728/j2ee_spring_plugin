public class OODemo07
{
	public static void main(String args[])
	{
		System.out.println("----------- �쳣����֮ǰ ----------") ;
		
		try
		{	
			System.out.println(1 / 1) ;
			System.out.println("*****************") ;
		}
		catch(Exception e)
		{
			System.out.println("���������������") ;
			System.out.println(e) ;
		}
		finally
		{
			// һ�������ͷ���Դ���ӣ�JDBC��IO
			System.out.println("�����Ƿ����쳣��Ҫִ���ҡ�����") ;
		}
		System.out.println("----------- �쳣����֮�� ----------") ;
	}
};