abstract class Person
{
	// ��˵����������Ϊһ�����󷽷���ͨ������ȥʵ��
	public void say()
	{
		System.out.println(this.getContent()) ;
	}
	public abstract String getContent() ;
};
// �����˷�Ϊ���� ��һ���ǹ��ˣ�һ����ѧ��
// �����й��ʣ�ѧ���гɼ�
// ������ѧ�����ǹ��ˣ��϶�������˵��
// ˵�������ݲ�һ��
class Worker extends Person
{
	public String getContent()
	{
		return "����˵���ˡ�����" ;
	}
};
class Student extends Person
{
	public String getContent()
	{
		return "ѧ��˵���ˡ�����" ;
	}
};
public class OODemo02
{
	public static void main(String args[])
	{
		Person p = null ;
		p = new Student() ;
		p.say() ;
	}
};