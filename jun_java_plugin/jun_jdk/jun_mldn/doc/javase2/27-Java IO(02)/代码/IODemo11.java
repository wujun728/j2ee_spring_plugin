import java.io.* ;
public class IODemo11
{
	public static void main(String args[])
	{
		File f = new File("f:\\lxh.txt") ;
		Reader in = null ;
		try
		{
			in = new FileReader(f) ;
		}
		catch (Exception e)
		{
		}
		// ����һ��byte���飬���ڽ�������
		char b[] = new char[500] ;
		int len = 0 ;
		try
		{
			// ���е����ݶ���byte������
			len = in.read(b) ;
		}
		catch (Exception e)
		{
		}
		try
		{
			in.close() ;
		}
		catch (Exception e)
		{
		}
		System.out.println(new String(b,0,len)) ;
		// �����ӡ������

	}
};