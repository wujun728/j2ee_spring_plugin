import java.net.* ;
import java.io.* ;

public class UDPServerInput
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket ds = null ;
		DatagramPacket dp = null ;
		// Ҫ��֤UDP��һ�����еĶ˿�
		ds = new DatagramSocket(5000) ;
		// String s = "HELLO MLDN" ;
		// BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)) ;
		System.out.print("������Ҫ���͵���Ϣ��") ;
		// s = buf.readLine() ;
		byte b[] = new byte[1024] ;
		int len = System.in.read(b) ;

		System.out.println(new String(b,0,len)) ;

		dp = new DatagramPacket(b,len,InetAddress.getByName("localhost"),8888) ;
		
		ds.send(dp) ;
		ds.close() ;
	}
};