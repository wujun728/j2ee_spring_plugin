// ʵ��Runnable�ӿ�
class Demo implements Runnable
{
	public void fun()
	{
		// �õ���ǰ�̵߳�����
		System.out.println(Thread.currentThread().getName()+" --> �����С�����") ;
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			this.fun() ;
		}
	}
};
public class ThreadDemo08
{
	public static void main(String args[])
	{
		Demo d = new Demo() ;
		Thread t1 = new Thread(d,"�߳�1") ;
		t1.start() ;
		for(int i=0;i<10;i++)
		{
			d.fun() ;
		}
	}
};