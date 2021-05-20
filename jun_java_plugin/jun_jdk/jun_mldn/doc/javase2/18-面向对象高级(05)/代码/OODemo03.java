abstract class Person
{
	private String name ;
	private int age ;
	public Person(String name,int age)
	{
		this.setName(name) ;
		this.setAge(age) ;
	}
	public void setName(String name)
	{
		this.name = name ;
	}
	public void setAge(int age)
	{
		this.age = age ;
	}
	public String getName()
	{
		return this.name ;
	}
	public int getAge()
	{
		return this.age ;
	}
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
	private float salary ;
	public Worker(String name,int age,float salary)
	{
		super(name,age) ;
		this.setSalary(salary) ;
	}
	public void setSalary(float salary)
	{
		this.salary = salary ;
	}
	public float getSalary()
	{
		return this.salary ;
	}
	public String getContent()
	{
		return "����˵ --> ������"+super.getName()+"�����䣺"+super.getAge()+"�����ʣ�"+this.getSalary() ;
	}
};
class Student extends Person
{
	private float score ;
	public Student(String name,int age,float score)
	{
		super(name,age) ;
		this.setScore(score) ;
	}
	public void setScore(float score)
	{
		this.score = score ;
	}
	public float getScore()
	{
		return this.score ;
	}
	public String getContent()
	{
		return "ѧ��˵ --> ������"+super.getName()+"�����䣺"+super.getAge()+"���ɼ���"+this.getScore() ;
	}
};
public class OODemo03
{
	public static void main(String args[])
	{
		Person p = null ;
		// p = new Student("����",30,90) ;
		p = new Worker("����",30,3000) ;
		p.say() ;
	}
};