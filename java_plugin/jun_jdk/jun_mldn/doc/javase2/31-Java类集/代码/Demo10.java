import java.util.* ;
public class Demo10
{
	public static void main(String args[])
	{
		Stack s = new Stack() ;
		s.push("A") ;
		s.push("B") ;
		s.push("C") ;
		s.push("D") ;
		s.push("E") ;
		// System.out.println(s.empty()) ;
		// ȡֵ
		while(!s.empty())
		{
			System.out.println(s.pop()) ;
		}
		// ��������Ѿ�ȫ���������ٵ�����ִ���
		s.pop() ;
	}
};