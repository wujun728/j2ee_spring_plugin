class Demo extends Thread
{
	private int ticket = 10 ;
	public void run()
	{
		while(this.ticket>0)
		{
			System.out.println("��Ʊ��"+this.ticket--) ;
		}
	}
};
public class ThreadDemo04
{
	public static void main(String args[])
	{
		// ׼���ĸ���Ʊ��
		Demo d1 = new Demo() ;
		Demo d2 = new Demo() ;
		Demo d3 = new Demo() ;
		Demo d4 = new Demo() ;

		d1.start() ;
		d2.start() ;
		d3.start() ;
		d4.start() ;
	}
};