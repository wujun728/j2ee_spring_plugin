public class JavaDemo07
{
	public static void main(String args[])
	{
		char c = 'a' ;
		// �ַ�����ֱ����intת��
		switch(c)
		{
			case 'a':
				System.out.println("����1���㡣") ;
				// ��ʾ�˳�switch���
				break ;
			case 'b':
				System.out.println("����2���㡣") ;
				break ;
			case 'c':
				System.out.println("����3���㡣") ;
				break ;
			default:
				// ���һ���������������ˣ���ִ��default���
				System.out.println("û���κ��������㡣") ;
				break ;
		}
	}
};