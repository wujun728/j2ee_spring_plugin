public class MethodArrayDemo02{
	public static void main(String args[]){
 		int temp[] = fun() ;	// ��������
		print(temp) ;
	}
	public static int[] fun(){
		int x[] = {1,3,5,7,9} ;
		return x ;	// ��������
	}
	public static void print(int[] x){
		for(int i=0;i<x.length;i++){
			System.out.print(x[i] + "��") ;
		}
	}
};