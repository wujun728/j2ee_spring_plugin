interface A
{
	// ���峣��
	// public static final String INFO = "LXH" ;
	String INFO = "LXH" ;
	// public abstract void say() ;
	public void say() ;
}

class X implements A
{
	// ����Ҫʵ�ֽӿ���ȫ���ĳ��󷽷�
	public void say()
	{
		System.out.println("��Ϣ�ǣ�"+INFO) ;
	}
};
public class OODemo10
{
	public static void main(String args[])
	{
		X x = new X() ;
		x.say() ;
	}
};