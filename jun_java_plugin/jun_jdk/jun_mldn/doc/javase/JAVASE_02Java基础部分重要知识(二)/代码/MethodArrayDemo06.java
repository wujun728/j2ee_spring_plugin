public class MethodArrayDemo06{
	public static void main(String args[]){
		int temp[] = {2,4,6,8} ;
 		fun() ;		// û�в���
 		fun(1) ;	// һ������
 		fun(1,3,5,7,9) ;	// һ������
		fun(temp) ;
	}
	public static void fun(int ... arg){
		for(int x:arg){
			System.out.print(x + "��") ;
		}
		System.out.println() ;
	}
};