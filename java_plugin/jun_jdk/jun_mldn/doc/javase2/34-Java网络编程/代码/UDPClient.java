import java.io.* ;
import java.net.* ;

public class UDPClient
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket ds = null ;
		DatagramPacket dp = null ;
		// �ֻ�����Ϣ�ͽ�����Ϣ���д�С���Ƶ�
		byte b[] = new byte[1024] ;
		// ��8888�˿���һֱ�ȴ���Ϣ����
		ds = new DatagramSocket(8888) ;
		dp = new DatagramPacket(b,b.length) ;
		ds.receive(dp) ;
		// �����ݰ���ȡ������
		// System.out.println(dp.getLength()) ;
		String str = new String(dp.getData(),0,dp.getLength()) ;
		System.out.println("���յ�������Ϊ��"+str) ;
		ds.close() ;
	}
};