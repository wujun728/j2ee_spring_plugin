import java.net.* ;
import java.io.* ;

public class UDPServer
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket ds = null ;
		DatagramPacket dp = null ;
		// Ҫ��֤UDP��һ�����еĶ˿�
		ds = new DatagramSocket(5000) ;
		String s = "HELLO MLDN" ;
		dp = new DatagramPacket(s.getBytes(),0,s.length(),InetAddress.getByName("localhost"),8888) ;
		ds.send(dp) ;
		ds.close() ;
	}
};