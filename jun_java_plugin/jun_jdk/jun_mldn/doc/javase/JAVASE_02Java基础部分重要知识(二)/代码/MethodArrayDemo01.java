public class MethodArrayDemo01{
	public static void main(String args[]){
 		int temp[] = {1,3,5,7,9} ;	// ��������
		fun(temp) ;
		print(temp) ;
	}
	public static void fun(int []x){
		x[0] = 6 ;	// �޸ĵ�һ��Ԫ��
	}
	public static void print(int[] x){
		for(int i=0;i<x.length;i++){
			System.out.print(x[i] + "��") ;
		}
	}
};