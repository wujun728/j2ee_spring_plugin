// ��дһ����̳���Thread��
class Demo implements Runnable
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
public class ThreadDemo03
{
	public static void main(String args[])
	{
		// ��Ϊʵ�ֵ���Runnable�ӿڣ�������Ҫͨ��Thread���������߳�
		Demo d1 = new Demo("�߳�1") ;
		Demo d2 = new Demo("�߳�2") ;
		Demo d3 = new Demo("�߳�3") ;
		Thread t1 = new Thread(d1) ;
		Thread t2 = new Thread(d2) ;
		Thread t3 = new Thread(d3) ;
		// �������߳�
		t1.start() ;
		t2.start() ;
		t3.start() ;
	}
};