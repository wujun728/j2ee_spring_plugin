import java.util.* ;
import java.lang.reflect.* ;
class Person
{
	private String name ;
	private int age ;
	private float score ;

	public Person(String name,int age,float score)
	{
		this.name = name ;
		this.age = age ;
		this.score = score ;
	}
	public String toString()
	{
		return "������"+this.name+"�����䣺"+this.age+"���ɼ���"+this.score ;
	}
};
public class AdvDemo09
{
	public static void main(String args[]) throws Exception
	{
		Person p = null ;
		// ͨ��Classʵ����Person����
		// p = (Person)Class.forName("Person").newInstance() ;
		// ��Դ���ڣ�����ʵ����ʱ��Ҫʹ�ù��췽��
		Class cl = Class.forName("Person") ;
		Object obj[] = {"����",new Integer(30),new Float(89)} ;
		Constructor c = cl.getConstructors()[0] ;
		p = (Person)c.newInstance(obj) ;
		System.out.println(p) ;
	}
};