interface A{
	public void fun() ;
}
class B implements A{
	public void fun(){
		System.out.println("Hello") ;
	}
};
public class InterPolDemo01{
	public static void main(String args[]){
		A a = new B() ;	// Ϊ�ӿ�ʵ����
		a.fun() ;
	}
};