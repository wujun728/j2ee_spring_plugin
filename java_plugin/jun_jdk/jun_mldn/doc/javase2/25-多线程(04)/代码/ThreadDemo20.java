class Demo implements Runnable
{
	boolean flag = true ;
	public void run()
	{
		int i = 0 ;
		while(flag)
		{
			System.out.println("���� i = "+i++) ;
		}
	}
};
public class ThreadDemo20
{
	public static void main(String args[])
	{
		// ϣ��whileѭ������100����֮�����Ҫֹͣ
		Demo d = new Demo() ;
		Thread t = new Thread(d) ;
		t.start() ;
		try
		{
			Thread.sleep(1000) ;
		}
		catch (Exception e)
		{
		}
		// �޸ı�־λ��ʹ�߳�ֹͣ
		d.flag = false ;
	}
};