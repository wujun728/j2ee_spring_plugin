import java.io.* ;

public class IODemo05
{
	public static void main(String args[])
	{
		File f = new File("F:\\testjava\\iodemo") ;
		// �г���Ŀ¼�µ�ȫ���ļ�
		// �г�֮ǰ������жϸ������ǲ���һ��Ŀ¼
		if(f.isDirectory())
		{
			String str[] = f.list() ;
			for(int i=0;i<str.length;i++)
			{
				System.out.println(str[i]) ;
			}
		}
		else
		{
			System.out.println("����Ŀ¼����") ;
		}
	}
};