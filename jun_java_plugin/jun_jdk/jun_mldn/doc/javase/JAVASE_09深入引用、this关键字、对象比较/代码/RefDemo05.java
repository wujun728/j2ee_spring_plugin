class Person{
	private String name ;
	private int age;
	private Book book ;	// һ������һ����
	private Person child ;
	public Person(String n,int a){
		this.setName(n) ;
		this.setAge(a) ;
	}
	public void setChild(Person c){
		child = c ;
	}
	public Person getChild(){
		return child ;
	}
	public void setBook(Book b){
		book = b ;
	}
	public void setName(String n){
		name = n ;
	}
	public void setAge(int a){
		age = a ;
	}
	public Book getBook(){
		return book ;
	}
	public String getName(){
		return name ;
	}
	public int getAge(){
		return age ;
	}
};
class Book{
	private String title ;
	private float price ;
	private Person person ;
	public Book(String t,float p){
		this.setTitle(t) ;
		this.setPrice(p) ;
	}
	public void setPerson(Person p){
		person = p ;
	}
	public void setTitle(String t){
		title = t ;
	}
	public void setPrice(float p){
		price = p ;
	}
	public Person getPerson(){
		return person ;
	}
	public String getTitle(){
		return title ;
	}
	public float getPrice(){
		return price ;
	}
};

public class RefDemo05{
	public static void main(String args[]){
		Person per = new Person("����",30) ;
		Person chd = new Person("����",10) ;
		Book bk = new Book("Java����",89.0f) ;
		Book bkc = new Book("ͯ������",89.0f) ;
		per.setChild(chd) ;
		chd.setBook(bkc) ;
		bkc.setPerson(chd) ;
		per.setBook(bk) ;		// һ������һ����
		bk.setPerson(per) ;	// һ��������һ����
		System.out.println(per.getBook().getTitle()) ;	// �����ҵ�����ӵ���������
		System.out.println(bk.getPerson().getName()) ;	// �����ҵ��˵�����
	}
};