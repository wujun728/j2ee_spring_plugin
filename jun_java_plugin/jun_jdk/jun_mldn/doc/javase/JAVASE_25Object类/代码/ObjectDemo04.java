public class ObjectDemo04{
	public static void main(String arg[]){
		int i[] = {1,2,3,4,5,6,7,8} ;	// ����
		Object obj = i ;	// ʹ��Object��������
		int x[] = (int[]) obj ;	// ����ת��
		for(int j=0;j<x.length;j++){
			System.out.print(x[j] + "��") ;
		}
	}
};