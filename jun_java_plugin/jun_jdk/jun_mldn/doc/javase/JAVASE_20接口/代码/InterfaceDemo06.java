interface A{
	public void printA() ;
}
interface B{
	public void printB() ;
}
interface Z extends A,B{	// X�ӿ�ͬʱ�̳���A��B�����ӿ�
	public void printZ() ;
}
abstract class C{
	public abstract void printC() ;
};
class X extends C implements Z{
	public void printA(){}
	public void printB(){}
	public void printC(){}
	public void printZ(){}
};
public class InterfaceDemo06{
	public static void main(String args[]){
		B b = new B() ;
		b.print() ;
		b.fun() ;
		b.funA() ;
	}
};