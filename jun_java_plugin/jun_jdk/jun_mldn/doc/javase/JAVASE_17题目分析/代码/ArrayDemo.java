class Array{
	private int temp[] = null ;	// ֻ���������飬���Ǵ�Сδ֪
	private int foot = 0 ;		// ���ڱ�����һ���ļ�¼��
	public Array(int len){
		if(len>0){
			this.temp = new int[len] ;	// ��ʱ��С���ⲿ����
		}else{
			this.temp = new int[1] ;	// ���ٿ���һ���ռ�
		}
	}
	public boolean add(int i){		// �������ݲ���
		if(this.foot<this.temp.length){	// ���п�λ
			this.temp[this.foot] = i ;	// ��������
			this.foot++ ;	// �ı䳤��
			return true ;	// ����ɹ�����true
		}else{
			return false ;	// ����ʧ��
		}
	}
	public int[] getArray(){	// ����ȫ��������
		return this.temp ;
	}
};
class SortArray extends Array{
	public SortArray(int len){
		super(len) ;
	}
	public int[] getArray(){	
		java.util.Arrays.sort(super.getArray()) ;	// �������
		return super.getArray() ;	// ���ص�������������
	}
};
class ReverseArray extends Array{
	public ReverseArray(int len){
		super(len) ;
	}
	public int[] getArray(){	
		int rt[] = new int[super.getArray().length] ;	// ���ݴ�С����������
		int count = rt.length-1 ;
		for(int x=0;x<super.getArray().length;x++){
			rt[count] = super.getArray()[x] ;
			count-- ;
		}
		return rt ;
	}
};
public class ArrayDemo{
	public static void main(String args[]){
		ReverseArray arr = new ReverseArray(6) ;
		System.out.println(arr.add(3)) ;
		System.out.println(arr.add(23)) ;
		System.out.println(arr.add(1)) ;
		System.out.println(arr.add(5)) ;
		System.out.println(arr.add(6)) ;
		System.out.println(arr.add(8)) ;
		System.out.println(arr.add(11)) ;
		System.out.println(arr.add(16)) ;
		print(arr.getArray()) ;
	}
	public static void print(int i[]){
		for(int x=0;x<i.length;x++){
			System.out.print(i[x] + "��") ;
		}
	}
};