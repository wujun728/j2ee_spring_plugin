import java.util.* ;
class Person
{
	private String name ;
	public Person(String name)
	{
		this.name = name ;
	}
	public String toString()
	{
		return "������"+this.name ;
	}
};
public class AdvDemo01
{
	public static void main(String args[])
	{
		// Person p = new Person("����") ;
		Map m = new HashMap() ;
		// m.put("����",new Person("����")) ;
		m.put(new Person("����"),"����") ;
		// m.put(p,"����") ;
		// System.out.println(m.get("����")) ;
		System.out.println(m.get(new Person("����"))) ;
		// System.out.println(m.get(p)) ;
	}
};