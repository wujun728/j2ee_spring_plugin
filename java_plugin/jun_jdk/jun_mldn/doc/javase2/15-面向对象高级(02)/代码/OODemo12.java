// Ϊ�˴���ļ򵥣�������ʱ����װ
class Employee
{
	String name ;
	int age ;
	float salary ;
	// ��ʾһ����Ա��һ���쵼
	Manager mgr = null ;
	public Employee(String name,int age,float salary)
	{
		this.name = name ;
		this.age = age ;
		this.salary = salary ;
	}
	public String say()
	{
		return "������"+this.name+"�����䣺"+this.age+"��нˮ��"+this.salary ;
	}
};

class Manager extends Employee
{
	// �������Ա��
	int number ;
	public Manager(String name,int age,float salary,int number)
	{
		super(name,age,salary) ;
		this.number = number ;
	}
	public String say()
	{
		return super.say()+"��������Ա����"+this.number ;
	}
};

public class OODemo12
{
	public static void main(String args[])
	{
		Employee e = new Employee("����",20,15000) ;
		Manager m = new Manager("����",30,3000,5) ;
		// m��e���쵼
		e.mgr = m ;
		System.out.println("��Ա��Ϣ��"+e.say()) ;
		// Ϊ�˷�ֹmgr������Ϊ�գ����Ϊ����϶�����NullPointerException
		if(e.mgr!=null)
		{
			System.out.println("������Ϣ��"+e.mgr.say()) ;
		}
	}
};