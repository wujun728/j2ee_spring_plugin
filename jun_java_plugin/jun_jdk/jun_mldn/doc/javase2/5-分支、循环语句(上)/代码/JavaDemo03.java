public class JavaDemo03
{
	public static void main(String args[])
	{
		float score = 95 ;
		if(score>=60)
		{
			if(score>=90&&score<=100)
			{
				System.out.println("�ȼ�ΪA�ȡ�") ;
			}
			else
			{
				if(score>=80&&score<90)
				{
					System.out.println("�ȼ�ΪB�ȡ�") ;
				}
				else
				{
					if(score>=70&&score<80)
					{
						System.out.println("�ȼ�ΪC�ȡ�") ;
					}
					else
					{
						System.out.println("�ȼ�ΪD�ȡ�") ;
					}
				}
			}
		}
		else
		{
			System.out.println("�ȼ�ΪE�ȡ�") ;
		}
	}
};