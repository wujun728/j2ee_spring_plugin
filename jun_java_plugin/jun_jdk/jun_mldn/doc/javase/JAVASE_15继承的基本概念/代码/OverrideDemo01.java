class A{
	public void fun(){
		System.out.println("A���ж���ķ�����") ;
	}
};
class B extends A {
	public void fun(){	// ��Ϊ������д
		System.out.println("B���ж���ķ�����") ;
	}
};
public class OverrideDemo01{
	public static void main(String args[]){
		B b = new B() ;
		b.fun() ;
	}
};