class A{
	private void fun(){
		System.out.println("A���ж���ķ�����") ;
	}
	public void print(){
		this.fun() ;		// ����fun()����
	}
};
class B extends A {
	void fun(){	// �˷���ʵ���������½���һ������
		System.out.println("B���ж���ķ�����") ;
	}
};
public class OverrideDemo03{
	public static void main(String args[]){
		B b = new B() ;
		b.print() ;
	}
};