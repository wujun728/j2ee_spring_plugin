import java.util.* ;
public class Demo06
{
	public static void main(String args[])
	{
		Map<java.lang.String,java.lang.String> m = new HashMap<java.lang.String,java.lang.String>() ;
		m.put("����","123456") ;
		m.put("����","654321") ;
		m.put("����","890762") ;

		// �Ѿ�׼������һ���绰�������ڴ��б�������
		// Ҫ���������ĵ绰
		System.out.println(m.get("����")) ;
	}
};