import java.io.* ;
public class IODemo10
{
	public static void main(String args[])
	{
		// 1����ʾҪ����lxh.txt�ļ�
		File f = new File("f:\\lxh.txt") ;
		Writer out = null ;
		// 2��ͨ������ʵ����
		try
		{
			out = new FileWriter(f) ;
		}
		catch (Exception e)
		{
		}
		String str = "HELLO MLDN ..." ;
		// 3�����ַ���д�뵽�ļ�֮��
		try
		{
			out.write(str) ;
			// ��ʾ��ջ���
			out.flush() ;
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