public class OODemo03
{
	public static void main(String args[])
	{
		System.out.println("----------- �쳣����֮ǰ ----------") ;
		try
		{
			System.out.println(1 / 1) ;
			System.out.println("*****************") ;
		}
		catch (ArithmeticException ae)
		{
			System.out.println("�����쳣�ࣺ") ;
			System.out.println(ae) ;
		}
		
		System.out.println("----------- �쳣����֮�� ----------") ;
	}
};