/*
�����в�������Person���е����������䣬����ӡ���
*/
class Person 
{
	String name ;
	int age ;
	String shout()
	{
		return "������"+name+"�����䣺"+age ;
	}
};
public class OODemo19
{
	public static void main(String args[])
	{
		// �������û�в��������ʾ��������˳�����
		if(args.length!=2)
		{
			// û����������
			// �����˳�
			System.out.println("���������д��󣬿ɰ����¸�ʽ���룺") ;
			System.out.println("java ������ ���� ����") ;
			System.exit(1) ;
		}
		// ���������һ�������֣��ڶ���������
		String name1 = args[0] ;
		int age1 = Integer.parseInt(args[1]) ;
		Person p = new Person() ;
		p.name = name1 ;
		p.age = age1 ;
		System.out.println(p.shout()) ;
	}
};