public class ArrayDemo01{
	public static void main(String args[]){
		int i[] = null ;
		// i = new int[10] ;	// ������10���ռ��С������
		System.out.print("���鿪��֮������ݣ�") ;
		for(int x=0;x<i.length;x++){
			System.out.print(i[x] + "��") ;
		}
		i[0] = 30 ;	// Ϊ��һ��Ԫ�ظ�ֵ
		i[9] = 60 ;	// Ϊ���һ��Ԫ�ظ�ֵ
		System.out.print("\n���鸳ֵ֮������ݣ�") ;
		for(int x=0;x<i.length;x++){
			System.out.print(i[x] + "��") ;
		}
	}
};