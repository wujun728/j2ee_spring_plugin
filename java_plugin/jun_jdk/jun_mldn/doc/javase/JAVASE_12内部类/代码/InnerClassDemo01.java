class Outer{
	private String name = "HELLO WORLD!!!" ;
	class Inner{
		public void print(){
			System.out.println("name = " + name) ;
		}
	};
	public void fun(){
		new Inner().print() ;	// ��ӡ��Ϣ
	};
};
public class InnerClassDemo01{
	public static void main(String args[]){
		new Outer().fun() ;
	}
};