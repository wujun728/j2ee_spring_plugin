// ��дһ����̳���Thread��
class Demo extends Thread
{
	// ��Ϊ���߳���Ҫһ�����������
	// ����Ҫ��дThread���е�run����
	private String info ;
	public Demo(String info)
	{
		this.info = info ;
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(this.info+"��i = "+i) ;
		}
	}
};
public class ThreadDemo02
{
	public static void main(String args[])
	{
		// �����ʱ������һ�����̲߳�������϶��ύ������
		Demo d1 = new Demo("�߳�1") ;
		Demo d2 = new Demo("�߳�2") ;
		Demo d3 = new Demo("�߳�3") ;
		d1.start() ;
		d2.start() ;
		d3.start() ;
	}
};