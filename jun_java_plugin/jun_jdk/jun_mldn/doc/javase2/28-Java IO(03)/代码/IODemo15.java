import java.io.* ;
public class IODemo15
{
	public static void main(String args[]) throws Exception
	{
		File f = new File("f:\\lxh.txt") ;
		// ʹ��PrintWriter
		// PrintWriter out = new PrintWriter(new FileWriter(f)) ;
		PrintWriter out = new PrintWriter(System.out) ;
		// �߱������ļ��д�ӡ���ݵ�����
		out.println(true) ;
		out.println(30) ;
		out.println("HELLO MLDN") ;
		out.close() ;
	}
};