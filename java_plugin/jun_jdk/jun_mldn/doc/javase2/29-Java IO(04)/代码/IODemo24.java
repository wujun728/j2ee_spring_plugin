import java.io.* ;

public class IODemo24
{
	public static void main(String args[]) throws Exception
	{
		OutputStream out = null ;
		out = new FileOutputStream(new File("f:\\lxh.txt")) ;
		String str = "���˻���ӭ�����MLDNѧϰ��" ;
		out.write(str.getBytes("GB2312")) ;
		out.close() ;
	}
};