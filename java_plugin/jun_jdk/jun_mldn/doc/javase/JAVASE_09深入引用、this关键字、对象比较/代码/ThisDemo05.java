class Person{
	private String name ;
	private int age;
	public Person(){
		System.out.println("�µĶ�������ˡ�") ;
	}
	public Person(String name){
		this() ;	// �����޲ι���
		this.name = name ;
	}
	public Person(String name,int age){
		this(name) ;	// ������һ�������Ĺ��췽��
		this.age = age ;
	}
	public void setName(String name){
		this.name = name ;
	}
	public void setAge(int age){
		this.age = age ;
	}
	public String getName(){
		return this.name ;
	}
	public int getAge(){
		return this.age ;
	}
};
public class ThisDemo05{
	public static void main(String args[]){
		Person per = new Person("����",30) ;
		System.out.println(per.getName() + " --> " + per.getAge()) ;
	}
};