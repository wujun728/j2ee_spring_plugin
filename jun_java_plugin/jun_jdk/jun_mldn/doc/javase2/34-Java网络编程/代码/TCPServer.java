import java.io.* ;
import java.net.* ;

public class TCPServer
{
	public static void main(String args[]) throws Exception
	{
		// ʹ��ServerSocket
		ServerSocket server = null ;
		// ÿһ���û��ڳ����о���һ��Socket
		Socket client = null ;
		server = new ServerSocket(8888) ;
		// �ȴ��ͻ�������
		client = server.accept() ;
		// ��ͻ��˴�ӡ��Ϣ��HELLO MLDN
		PrintWriter out = null ;
		// ׼����ͻ��˴�ӡ��Ϣ
		out = new PrintWriter(client.getOutputStream()) ;
		out.println("HELLO MLDN") ;
		out.close() ;
		client.close() ;
		server.close() ;
	}
};
