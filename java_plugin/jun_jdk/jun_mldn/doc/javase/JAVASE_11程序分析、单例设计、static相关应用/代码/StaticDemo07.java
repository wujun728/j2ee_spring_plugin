class Person{
	private String name ;
	private static int count ; 
	public Person(){
		count++ ;
		System.out.println("������" + count + "��ʵ��������") ;
	}
	public String getInfo(){
		return "������" + this.name ;
	}
};
public class StaticDemo07{
	public static void main(String args[]){
		new Person() ;	
		new Person() ;	
		new Person() ;	
		new Person() ;	
		new Person() ;	
	}
};