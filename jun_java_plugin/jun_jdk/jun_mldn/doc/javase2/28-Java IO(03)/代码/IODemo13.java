import java.io.* ;
public class IODemo13
{
	public static void main(String args[]) throws Exception
	{
		String str = "LXHMLDN" ;
		// �ַ������Ǵ�д�ģ�����Ҫ����Խ��ַ�����λСд
		byte[] b = str.getBytes() ;
		ByteArrayInputStream in = new ByteArrayInputStream(b) ;
		ByteArrayOutputStream out = new ByteArrayOutputStream() ;
		// ����������Ҫ���ǽ���д��ΪСд
		// ֻ��һ��һ���ֽڵĶ�
		int c = 0 ;
		// ���û�ж����ͣ��򲻻���-1
		while((c=in.read())!=-1)
		{
			int ch = (int)Character.toLowerCase((char)c) ;
			// ���������д
			out.write(ch) ;
		}

		b = out.toByteArray() ;
		System.out.println("����Ϊ��"+new String(b)) ;
	}
};