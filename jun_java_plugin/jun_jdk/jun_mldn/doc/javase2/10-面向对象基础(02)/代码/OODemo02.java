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
};
// Ҫʹ������Ҫͨ������
public class OODemo02
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
		// ��������ô���
		lxh2 = lxh1 ;

		lxh2.name = "ħ������" ;
		lxh1.age = 20 ;

		// ���������
		System.out.println("������"+lxh1.name) ;
		System.out.println("���䣺"+lxh1.age) ;
		System.out.println("*********************************") ;
		System.out.println("������"+lxh2.name) ;
		System.out.println("���䣺"+lxh2.age) ;
	}
};