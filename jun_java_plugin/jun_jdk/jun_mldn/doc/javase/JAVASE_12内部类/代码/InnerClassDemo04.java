class Outer{
	private static String name = "HELLO WORLD!!!" ;
	static class Inner{
		public void print(){
			System.out.println("name = " + name) ;
		}
	};
};
public class InnerClassDemo04{
	public static void main(String args[]){
		Outer.Inner in = new Outer.Inner() ;	// ʵ�����ڲ������
		in.print() ;
	}
};