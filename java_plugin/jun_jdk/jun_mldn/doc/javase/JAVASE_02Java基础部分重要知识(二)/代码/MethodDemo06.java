public class MethodDemo06{
	public static void main(String args[]){
		fun(10) ;
		fun(3) ;
	}
	public static void fun(int x){
		System.out.println("���뷽����") ;
		if(x==3){
			return  ;	// ���ط����ı����ô�
		}
		System.out.println("����������") ;
	}
};