class Person{
	private String name ;
	private int age;
	String city = "A��" ;
	public Person(String name,int age){
		this.name = name ;
		this.age = age ;
	}
	public String getInfo(){
		return "������" + this.name + "�����䣺" + this.age + "�����У�" + city ;
	}
};
public class StaticDemo01{
	public static void main(String args[]){
		Person per1 = new Person("����",30) ;
		Person per2 = new Person("����",31) ;
		Person per3 = new Person("����",30) ;
		System.out.println(per1.getInfo()) ;
		System.out.println(per2.getInfo()) ;
		System.out.println(per3.getInfo()) ;
		per1.city = "B��" ;
		System.out.println(per1.getInfo()) ;
		System.out.println(per2.getInfo()) ;
		System.out.println(per3.getInfo()) ;
	}
};