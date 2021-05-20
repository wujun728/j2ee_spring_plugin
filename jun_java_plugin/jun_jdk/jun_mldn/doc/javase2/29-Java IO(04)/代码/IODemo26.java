// ����һ��Person�࣬��Person��Ķ������л�
import java.io.* ;

class Person implements Serializable
{
	private String name ;
	private transient int age ;
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
public class IODemo26
{
	public static void main(String args[]) throws Exception
	{
		Person per = new Person("���˻�",30) ;
		ser(per) ;
		System.out.println(dser()) ;
	}
	// ����һ������������ɶ�������л�
	public static void ser(Person per) throws Exception
	{
		ObjectOutputStream oos = null ;
		oos = new ObjectOutputStream(new FileOutputStream(new File("f:\\lxh.txt"))) ;
		oos.writeObject(per) ;
		oos.close() ;
	}
	// �����л�
	public static Person dser() throws Exception
	{
		ObjectInputStream ois = null ;
		ois = new ObjectInputStream(new FileInputStream(new File("f:\\lxh.txt"))) ;
		Object obj = ois.readObject() ;
		ois.close() ;
		return (Person)obj ;
	}
};