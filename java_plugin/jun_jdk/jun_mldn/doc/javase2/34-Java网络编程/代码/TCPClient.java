import java.io.* ;
import java.net.* ;
public class TCPClient
{
	public static void main(String args[]) throws Exception
	{
		// ��ʾһ���ͻ��˵�Socket
		Socket client = null ;
		// ��ʾһ���ͻ��˵�������Ϣ
		BufferedReader buf = null ;
		client = new Socket("localhost",8888) ;
		buf = new BufferedReader(new InputStreamReader(client.getInputStream())) ;
		System.out.println(buf.readLine()) ;
		buf.close() ;
		client.close() ;
	}
};