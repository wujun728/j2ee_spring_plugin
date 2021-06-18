class Single{
	private static Single instance = new Single() ;
	private Single(){	// �����췽��˽�л�
	}
	public static Single getInstance(){
		return instance ;
	}
	public void print(){
		System.out.println("hello world!!!") ;
	}
};
public class SingleDemo{
	public static void main(String args[]){
		Single s = null ;		// ��������
		s = Single.getInstance() ;		// ʵ��������
		s.print() ;
	}
};