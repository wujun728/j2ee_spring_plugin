import java.io.* ;
public class IODemo14
{
	public static void main(String args[]) throws Exception 
	{
		// ͨ��������ɲ�ͬ�Ĺ���
		OutputStream out = null ;
		// System.out��PrintStream����OutputStream����
		out = System.out ;
		// ���ڵ�out����߱�������Ļ�ϴ�ӡ���ݵ�����
		String str = "HELLO MLDN --> LXH" ;
		out.write(str.getBytes()) ;
		out.close() ;
	}
};