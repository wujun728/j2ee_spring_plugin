interface A{
	// public static final String INFO = "CHINA" ;
	String INFO = "CHINA" ;	// ȫ�ֳ���
	// public abstract void print() ;
	void print() ;	// ���󷽷�
	public void fun() ;	// ���󷽷�
}
interface C{
	public void funA() ;
}
class B implements A,C{	// ����Bʵ���˽ӿ�A
	public void print(){	// ʵ�ֳ��󷽷�
		System.out.println("HELLO WORLD!!!") ;
	}
	public void fun(){
		System.out.println(INFO);	// ���ȫ�ֳ���
	}
	public void funA(){
		System.out.println("��Ϣ��" + INFO) ;
	}
};
public class InterfaceDemo03{
	public static void main(String args[]){
		B b = new B() ;
		b.print() ;
		b.fun() ;
		b.funA() ;
	}
};