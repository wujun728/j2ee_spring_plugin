// Ϊ�˽���static�������е������ݲ���װ
class Person
{
	private static String code ;
	String name ;
	int age ;
	String shout() 
	{
		return "�������룺"+code+"��������"+name+"�����䣺"+age ;
	}
	// �����Ҫ�Ļ�������code����������Ӧ��ͨ��һ���������м��
	// ������ôд��
	// ��̬��������������ֱ�ӵ���
	static void setCode(String c)
	{
		// ��Ҫ����this
		code = c ;
	}
	// �ܲ���ͨ����̬����Ϊ���е����Ը�ֵ
	static void setName(String n)
	{
		name = n ;
	}
};

class OODemo13
{
	public static void main(String args[])
	{
		Person.setCode("110") ;


		Person p1 = new Person() ;
		Person p2 = new Person() ;
		//p1.code = "110" ;
		p1.name = "ħ��" ;
		p1.age = 3 ;
		//p2.code = "120" ;
		p2.name = "��" ;
		p2.age = 30 ;

		Person p3 = new Person() ;
		//p3.code = "130" ;

		// Ӧ���ɶ��������������ͳһ���޸�

		System.out.println(p1.shout()) ;
		System.out.println(p2.shout()) ;
	}
};