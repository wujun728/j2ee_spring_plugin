import java.io.* ;

public class IODemo02
{
	public static void main(String args[])
	{
		File f = new File("f:\\mldn.txt") ;
		if(f.exists())
		{
			System.out.println("�ļ��Ѵ��ڡ�") ;
		}
		else
		{
			System.out.println("�ļ�������") ;
		}
	}
};