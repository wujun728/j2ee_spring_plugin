public class MethodDemo03{
	public static void main(String args[]){
		System.out.println(add(10,20)) ;
		System.out.println(add(30,30)) ;
		System.out.println(add(30,30,30)) ;
		System.out.println(add(30.03f,30.01f)) ;
	}
	public static int add(int x ,int y){
		int temp = x + y ; 
		return temp ;	// ������������
	}
	public static int add(int x ,int y,int z){
		int temp = x + y + z ; 
		return temp ;	// ������������
	}
	public static float add(float x ,float y){
		float temp = x + y ; 
		return temp ;	// ������������
	}
};