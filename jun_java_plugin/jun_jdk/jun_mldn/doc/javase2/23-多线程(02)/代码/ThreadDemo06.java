// ʵ��Runnable�ӿ�
class Demo implements Runnable
{
	public void fun()
	{
		System.out.println(Thread.currentThread()) ;
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			this.fun() ;
		}
	}
};
public class ThreadDemo06
{
	public static void main(String args[])
	{
		Demo d = new Demo() ;
		Thread t1 = new Thread(d) ;
		Thread t2 = new Thread(d) ;
		Thread t3 = new Thread(d) ;

		// �����߳�
		t1.start() ;
		t2.start() ;
		t3.start() ;
	}
};