// Object����������ĸ��࣬���һ����û����ȷ�����̳����Ǹ���
// ��϶���̳�Object��
class Person// extends Object
{
	public String toString()
	{
		return "Hello MLDN" ;
	}
};
public class OODemo01
{
	public static void main(String args[])
	{
		Person p = new Person() ;
		// Ĭ������´�ӡ����ʵ���Ͼ��൱�ڵ��ö����е�toString����
		System.out.println(p) ;
	}
};