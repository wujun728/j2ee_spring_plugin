public class JavaDemo09
{
	public static void main(String args[])
	{
		int i[] = new int[10] ;
		// ����init�����Ϳ���Ϊ�����ʼ��
		init(i) ;
		// ��ӡ����
		print(i) ;
	}
	// ����һ��������Ҫ��˷�������Ϊ�����е����ݳ�ʼ������
	// 0--> 1��1--> 2
	// �Ѷ��ڴ�ռ������ȡ����֮���ڷ����н��мӹ�
	public static void init(int x[])
	{
		// ��������ĳ�ʼ��
		for (int y=0;y<x.length;y++)
		{
			x[y] = y + 1 ;
		}
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