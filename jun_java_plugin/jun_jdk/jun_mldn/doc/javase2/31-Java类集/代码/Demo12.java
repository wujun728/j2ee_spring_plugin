import java.util.* ;
public class Demo12
{
	public static void main(String args[])
	{
		Properties p = new Properties() ;
		p.setProperty("�й����׶�","����") ;
		p.setProperty("�ձ����׶�","����") ;
		p.setProperty("�������׶�","��ʢ��") ;

		System.out.println(p.getProperty("�ձ����׶�","�����ڡ�")) ;
	}
};