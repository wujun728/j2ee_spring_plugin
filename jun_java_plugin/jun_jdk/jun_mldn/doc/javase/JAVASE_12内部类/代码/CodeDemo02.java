class Demo{
	{	// �����
		System.out.println("*********** ����� *************") ;
	}
	public Demo(){	// ���췽��
		System.out.println("*********** ���췽�� *************") ;
	}
};
public class CodeDemo02{
	public static void main(String args[]){
		new Demo() ;
		new Demo() ;
		new Demo() ;
	}
};