public class JavaDemo10
{
	public static void main(String args[])
	{
		int i[] = init(20) ;
		// ����init�����Ϳ���Ϊ�����ʼ��
		// init(i) ;
		// ��ӡ����
		print(i) ;
	}
	// ����һ��������Ҫ��˷�������Ϊ�����е����ݳ�ʼ������
	// 0--> 1��1--> 2
	// �Ѷ��ڴ�ռ������ȡ����֮���ڷ����н��мӹ�
	// ��ʾ���鿪�ٵĴ�С
	public static int[] init(int len)
	{
		// java�е������ǿ��Զ�̬���ٵ�
		int x[] = new int[len] ;
		// ��������ĳ�ʼ��
		for (int y=0;y<x.length;y++)
		{
			x[y] = y + 1 ;
		}
		return x ;
	}
	// ����ڶ����������˷������ڴ�ӡ����
	public static void print(int x[])
	{
		for (int y=0;y<x.length;y++)
		{
			System.out.println("����["+y+"] = "+x[y]) ;
		}
	}
};