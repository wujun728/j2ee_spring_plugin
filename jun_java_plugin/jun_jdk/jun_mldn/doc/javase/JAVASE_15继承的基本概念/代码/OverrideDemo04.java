class A{
	public void fun(){
		System.out.println("A���ж���ķ�����") ;
	}
};
class B extends A {
	public void fun(){	// �˷���ʵ���������½���һ������
		super.fun() ;	// ���ø����е�fun()����
		System.out.println("B���ж���ķ�����") ;
	}
};
public class OverrideDemo04{
	public static void main(String args[]){
		B b = new B() ;
		b.fun() ;
	}
};