interface A{
	// public static final String INFO = "CHINA" ;
	String INFO = "CHINA" ;	// ȫ�ֳ���
	// public abstract void print() ;
	void print() ;	// ���󷽷�
	public void fun() ;	// ���󷽷�
}
class B implements A{	// ����Bʵ���˽ӿ�A
	public void print(){	// ʵ�ֳ��󷽷�
		System.out.println("HELLO WORLD!!!") ;
	}
	public void fun(){
		System.out.println(INFO);	// ���ȫ�ֳ���
	}
};
public class InterfaceDemo02{
	public static void main(String args[]){
		B b = new B() ;
		b.print() ;
		b.fun() ;
	}
};