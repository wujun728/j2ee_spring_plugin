// ʵ��Runnable�ӿ�
class Demo implements Runnable
{
	public void fun()
	{
		// �õ���ǰ�̵߳�����
		System.out.println(Thread.currentThread().getName()+"�����С�����") ;
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			this.fun() ;
		}
	}
};
public class ThreadDemo07
{
	public static void main(String args[])
	{
		Demo d = new Demo() ;
		Thread t1 = new Thread(d,"�߳�1") ;
		Thread t2 = new Thread(d,"�߳�2") ;
		Thread t3 = new Thread(d,"�߳�3") ;
		/*
		t1.setName("�߳�1") ;
		t2.setName("�߳�2") ;
		t3.setName("�߳�3") ;
		*/
		// �����߳�
		t1.start() ;
		t2.start() ;
		t3.start() ;
	}
};