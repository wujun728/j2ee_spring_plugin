public class JavaDemo11
{
	public static void main(String args[])
	{
		int source[] = {1,2,3,4,5,6} ;
		int dest[] = {11,22,33,44,55,66,77,88,99} ;
		System.out.println("------- dest���鿽��֮ǰ ---------") ;
		printArray(dest) ;
		// ��������Ŀ���
		System.arraycopy(source,0,dest,0,source.length) ;
		
		System.out.println("------- dest���鿽��֮�� ---------") ;
		printArray(dest) ;
	}
	public static void printArray(int x[])
	{
		for (int i=0;i<x.length;i++)
		{
			System.out.println("����["+i+"] = "+x[i]) ;
		}
	}
};