/*
�����ʽ��
class ������
{}

��׼�������淶������ĸ��д
*/
class Person
{
	// ����
	String name ;
	// ����
	int age ;

	// ����һ��˵���ķ���
	public void shout()
	{
		System.out.println("������"+name) ;
		System.out.println("���䣺"+age) ;
	}
};
// Ҫʹ������Ҫͨ������
public class OODemo03
{
	public static void main(String args[])
	{
		// ��ʽ���� ������ = new ��() ;
		// ����һ������ lxh1
		// �ڷ�������������ʱ���븳ֵ
		Person lxh1 = null ;
		// Ϊ����ʵ���������ٶ��ڴ�ռ�
		lxh1 = new Person() ;
		lxh1.name = "���˻�" ;
		lxh1.age = 28 ;

		Person lxh2 = new Person() ;

		lxh2.name = "ħ������" ;
		lxh1.age = 20 ;

		// ���������
		lxh1.shout() ;
		System.out.println("*********************************") ;
		lxh2.shout() ;
	}
};