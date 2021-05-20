class Person
{
	// ���������	���˻�	 ����
	//				MLDN		��վ
	private String name = "���˻�" ;
	private String content = "����" ;
	private boolean flag = false ;
	// ����һ�����õ�ͬ������
	public synchronized void set(String name,String content)
	{
		// ���Ϊ�̵����ʾ�������ã�����ȴ���true
		// ֵ�Ǽ٣����ʾҪ�ȴ�����ȥ����
		if(flag)
		{
			try
			{
				wait() ;
			}
			catch (Exception e)
			{
			}
		}
		this.name = name ;
		try
		{
			Thread.sleep(100) ;
		}
		catch (Exception e)
		{
		}
		this.content = content ;
		// �������֮��Ҫ�ı��
		flag = true ;
		notifyAll() ;
	}
	public synchronized String get()
	{
		if(!flag)
		{
			try
			{
				wait() ;
			}
			catch (Exception e)
			{
			}
		}
		String str = this.name+" --> "+this.content ;
		// ���Ϊ��ƣ����ʾ����ȡ������ȴ���false
		flag = false ;
		notifyAll() ;
		return str ;
	}
};
class Pro implements Runnable
{
	private Person per = null ;
	public Pro(Person per)
	{
		this.per = per ;
	}
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			if(i%2==0)
			{
				per.set("MLDN","��վ") ;
			}
			else
			{
				per.set("���˻�","����") ;
			}
		}
	}
};

class Cust implements Runnable
{
	private Person per = null ;
	public Cust(Person per)
	{
		this.per = per ;
	}
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(per.get()) ;
		}
	}
} ;

public class ThreadDemo19
{
	public static void main(String args[])
	{
		Person per = new Person() ;
		Pro p = new Pro(per)  ;
		Cust c = new Cust(per) ;

		new Thread(p).start() ;
		new Thread(c).start() ;
	}
};
