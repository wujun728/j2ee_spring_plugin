class A{
	public void fun(){
		System.out.println("A���ж���ķ�����") ;
	}
};
class B extends A {
	void fun(){	// ��Ϊ������д
		System.out.println("B���ж���ķ�����") ;
	}
};
public class OverrideDemo02{
	public static void main(String args[]){
		B b = new B() ;
		b.fun() ;
	}
};