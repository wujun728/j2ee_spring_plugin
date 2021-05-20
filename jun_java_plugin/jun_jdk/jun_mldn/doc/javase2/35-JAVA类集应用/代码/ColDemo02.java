import java.util.* ;
class Student
{
	private String name ;

	private List allSubjects ;

	public Student()
	{
		this.allSubjects = new ArrayList() ;
	}
	public Student(String name)
	{
		this() ;
		this.setName(name) ;
	}

	public List getAllSubjects()
	{
		return this.allSubjects ;
	}
	
	public void setName(String name)
	{
		this.name = name ;
	}
	public String getName()
	{
		return this.name ;
	}
	public String toString()
	{
		return "ѧ��������"+this.getName() ;
	}
};
class Subject
{
	private String name ;
	
	private List allStudents ;

	public Subject()
	{
		this.allStudents = new ArrayList() ;
	}
	public Subject(String name)
	{
		this() ;
		this.setName(name) ;
	}

	public List getAllStudents()
	{
		return this.allStudents ;
	}

	public void setName(String name)
	{
		this.name = name ;
	}
	public String getName()
	{
		return this.name ;
	}
	public String toString()
	{
		return "�γ����ƣ�"+this.getName() ;
	}
};

public class ColDemo02
{
	public static void main(String args[])
	{
		Student s1 = new Student("����") ;
		Student s2 = new Student("����") ;
		Student s3 = new Student("����") ;
		Student s4 = new Student("����") ;
		Student s5 = new Student("����") ;

		Subject su1 = new Subject("C++") ;
		Subject su2 = new Subject("JAVA") ;
		Subject su3 = new Subject("�������") ;

		// ���ѧ��ѡ��ͬһ�ſγ�
		su1.getAllStudents().add(s1) ;
		su1.getAllStudents().add(s2) ;
		su1.getAllStudents().add(s3) ;

		su2.getAllStudents().add(s2) ;
		su2.getAllStudents().add(s4) ;

		su3.getAllStudents().add(s5) ;

		s1.getAllSubjects().add(su1) ;
		s2.getAllSubjects().add(su1) ;
		s2.getAllSubjects().add(su2) ;
		s3.getAllSubjects().add(su1) ;
		s4.getAllSubjects().add(su2) ;
		s5.getAllSubjects().add(su3) ;

		print(su1) ;
		print(su2) ;
		print(su3) ;

		System.out.println("------------------------") ;
		print(s1) ;
		print(s2) ;
		print(s3) ;
		print(s4) ;
		print(s5) ;
	}
	public static void print(Subject s)
	{
		System.out.println("* �γ���Ϣ��"+s) ;
		Iterator iter = s.getAllStudents().iterator() ;
		while(iter.hasNext())
		{
			System.out.println(" |- "+iter.next()) ;
		}
	}
	public static void print(Student s)
	{
		System.out.println("* ѧ����Ϣ��"+s) ;
		Iterator iter = s.getAllSubjects().iterator() ;
		while(iter.hasNext())
		{
			System.out.println(" |- "+iter.next()) ;
		}
	}
};
