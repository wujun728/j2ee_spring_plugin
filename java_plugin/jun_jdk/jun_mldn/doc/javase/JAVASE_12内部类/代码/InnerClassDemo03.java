class Outer{
	private String name = "HELLO WORLD!!!" ;
	class Inner{
		public void print(){
			System.out.println("name = " + name) ;
		}
	};
};
public class InnerClassDemo03{
	public static void main(String args[]){
		Outer out = new Outer() ;	// �ⲿ��ʵ��
		Outer.Inner in = out.new Inner() ;	// ʵ�����ڲ������
		in.print() ;
	}
};