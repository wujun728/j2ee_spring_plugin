class DemoA
{
	public synchronized void funA(DemoB db)
	{
		System.out.println("DemoA --> ����DemoA�е�funA����") ;
		try
		{
			Thread.sleep(100) ;
		}
		catch (Exception e)
		{
		}
		db.fun2() ;
	}
	public synchronized void fun2()
	{
		System.out.println("DemoA --> public void fun2()") ;
	}
};
class DemoB
{
	public synchronized void funB(DemoA da)
	{
		System.out.println("DemoB --> ����DemoB�е�funA����") ;
		try
		{
			Thread.sleep(100) ;
		}
		catch (Exception e)
		{
		}
		da.fun2() ;
	}
	public synchronized void fun2()
	{
		System.out.println("DemoB --> public void fun2()") ;
	}
};

class ThreadDead implements Runnable
{
	private DemoA da = new DemoA() ;
	private DemoB db = new DemoB() ;
	public ThreadDead()
	{
		new Thread(this).start() ;
		da.funA(db) ;
	}

	public void run()
	{
		db.funB(da) ;
	}
};

public class ThreadDemo16
{
	public static void main(String args[])
	{
		new ThreadDead() ;
	}
};

