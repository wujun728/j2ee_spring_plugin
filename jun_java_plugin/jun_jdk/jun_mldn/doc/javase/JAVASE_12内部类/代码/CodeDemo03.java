class Demo{
	{	// �����
		System.out.println("*********** ����� *************") ;
	}
	static{
		System.out.println("*********** ���еľ�̬�� *************") ;
	}
	public Demo(){	// ���췽��
		System.out.println("*********** ���췽�� *************") ;
	}
};
public class CodeDemo03{
	static{
		System.out.println("*********** �����еľ�̬�� *************") ;
	}
	public static void main(String args[]){
		new Demo() ;
		new Demo() ;
		new Demo() ;
	}
};