public class MethodArrayDemo03{
	public static void main(String args[]){
 		int temp[] = fun() ;	// ��������
		java.util.Arrays.sort(temp) ;	// �����������
		print(temp) ;
	}
	public static int[] fun(){
		int x[] = {23,1,5,3,24,3,56,4,3,1} ;
		return x ;	// ��������
	}
	public static void print(int[] x){
		for(int i=0;i<x.length;i++){
			System.out.print(x[i] + "��") ;
		}
	}
};