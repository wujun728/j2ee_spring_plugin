import java.io.* ;
public class IODemo18
{
	public static void main(String args[]) throws Exception
	{
		InputStream in = null ;
		// ���ݵȴ����̵�����
		in = System.in ;
		String str = "" ;
		int c = 0 ;
		while((c=in.read())!=-1)
		{
			str += (char)c;
		}
		in.close() ;
		System.out.println("���������Ϊ��"+str) ;
	}
};