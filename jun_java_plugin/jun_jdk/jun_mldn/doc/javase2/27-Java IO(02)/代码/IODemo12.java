import java.io.* ;
// ����һ��������
class SendDemo implements Runnable
{
	private PipedOutputStream out ;
	public SendDemo()
	{
		out = new PipedOutputStream() ;
	}
	public PipedOutputStream getOut()
	{
		return this.out ;
	}
	public void run()
	{
		String str = "Hello MLDN" ;
		try
		{
			out.write(str.getBytes()) ;
			out.close() ;
		}
		catch (Exception e)
		{
		}
		System.out.println("SendDemo --> ���͵����ݣ�"+str) ;
	}
};

class ReceDemo implements Runnable
{
	private PipedInputStream in = null ;
	public ReceDemo()
	{
		in = new PipedInputStream() ;
	}
	public PipedInputStream getIn()
	{
		return this.in ;
	}
	public void run()
	{
		byte b[] = new byte[1024] ;
		int len = 0 ;
		try
		{
			len = in.read(b) ;
			in.close() ;
		}
		catch (Exception e)
		{
			System.out.println(e) ;
		}
		System.out.println("ReceDemo --> �յ��������ǣ�"+new String(b,0,len)) ;
	}
};

public class IODemo12
{
	public static void main(String args[])
	{
		SendDemo sd = new SendDemo() ;
		ReceDemo rd = new ReceDemo() ;
		Thread send = new Thread(sd) ;
		Thread rece = new Thread(rd) ;
		// �������߳̽�������
		PipedOutputStream out = sd.getOut() ;
		PipedInputStream in = rd.getIn() ;
		// ��������ӵ�����
		try
		{
			out.connect(in) ;
		}
		catch (Exception e)
		{
		}
		send.start() ;
		rece.start() ;
	}
};