import java.io.* ;
public class IODemo17
{
	public static void main(String args[]) throws Exception
	{
		InputStream in = null ;
		// ���ݵȴ����̵�����
		in = System.in ;
		byte b[] = new byte[7] ;
		// ����ʱ���ǵȴ��û�������
		int len = in.read(b) ;
		in.close() ;
		System.out.println("���������Ϊ��"+new String(b,0,len)) ;
	}
};