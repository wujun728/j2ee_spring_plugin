public class JavaDemo15
{
	public static void main(String args[])
	{
		for (int i=1;i<=100;i++)
		{
			if(i>=50)
			{
				// �����жϣ����ٱ�ִ��
				// breakһ����if�������
				break ;
			}
			if(i%2==0)
			{
				System.out.print(i+"\t") ;
			}
		}
	}
};