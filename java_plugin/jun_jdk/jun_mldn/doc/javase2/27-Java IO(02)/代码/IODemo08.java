import java.io.* ;
public class IODemo08
{
	public static void main(String args[])
	{
		// 1����ʾҪ����lxh.txt�ļ�
		File f = new File("f:\\lxh.txt") ;
		OutputStream out = null ;
		// 2��ͨ������ʵ����
		// ʹ��FileOutputStream����
		try
		{
			out = new FileOutputStream(f) ;
		}
		catch (Exception e)
		{
		}
		// ���ַ���ת��Ϊbyte����
		String str = "HELLO MLDN ..." ;
		byte b[] = str.getBytes() ;
		// 3����byte����д�뵽�ļ�֮�У�д����byte�����е�����
		try
		{
			out.write(b) ;
		}
		catch (Exception e)
		{
		}
		// 4���ر��ļ�����
		/*
		try
		{
			out.close() ;
		}
		catch (Exception e)
		{
		}
		*/
	}
};