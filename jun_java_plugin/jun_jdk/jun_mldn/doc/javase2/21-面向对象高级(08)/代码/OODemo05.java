public class OODemo05
{
	public static void main(String args[])
	{
		System.out.println("----------- �쳣����֮ǰ ----------") ;
		
		try
		{
			// �׳�����һ���쳣���ʵ��������
			System.out.println("��һ��������"+args[0]) ;	
			System.out.println(1 / 0) ;
			System.out.println("*****************") ;
		}

		/*
		catch (ArithmeticException ae)
		{
			System.out.println("�����쳣�ࣺ") ;
			System.out.println(ae) ;
		}
		catch(ArrayIndexOutOfBoundsException abe)
		{
			System.out.println("�����ڶ����쳣��") ;
			System.out.println(abe) ;
		}
		*/
		catch(Exception e)
		{
			System.out.println("���������������") ;
			System.out.println(e) ;
		}
		
		System.out.println("----------- �쳣����֮�� ----------") ;
	}
};