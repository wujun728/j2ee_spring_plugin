// ʵ��Runnable�ӿ�
class Demo implements Runnable
{
	public void fun()
	{
		for(int i=0;i<10;i++)
		{
			try
			{
				Thread.sleep(1000) ;
			}
			catch (Exception e)
			{
			}
			System.out.println(Thread.currentThread().getName()+" --> �����С�����") ;
		}
	}
	public void run()
	{
		this.fun() ;
	}
};
public class ThreadDemo10
{
	public static void main(String args[])
	{
		Demo d = new Demo() ;
		Thread t1 = new Thread(d,"�߳�1") ;
		Thread t2 = new Thread(d,"�߳�2") ;
		t1.start() ;
		t2.start() ;		
	}
};