// Object����������ĸ��࣬���һ����û����ȷ�����̳����Ǹ���
// ��϶���̳�Object��
class Person// extends Object
{
	private String name ;
	private int age ;
	public Person(String name,int age)
	{
		this.name = name ;
		this.age = age ;
	}
	public String toString()
	{
		return "������"+this.name+"�����䣺"+this.age ;
	}
};
public class OODemo02
{
	public static void main(String args[])
	{
		Person p = new Person("LXH",30) ;
		// Ĭ������´�ӡ����ʵ���Ͼ��൱�ڵ��ö����е�toString����
		System.out.println(p) ;
	}
};