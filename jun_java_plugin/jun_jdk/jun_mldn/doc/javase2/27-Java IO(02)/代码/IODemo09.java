import java.io.* ;
public class IODemo09
{
	public static void main(String args[])
	{
		File f = new File("f:\\lxh.txt") ;
		InputStream in = null ;
		try
		{
			in = new FileInputStream(f) ;
		}
		catch (Exception e)
		{
		}
		// ����һ��byte���飬���ڽ�������
		byte b[] = new byte[500] ;
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