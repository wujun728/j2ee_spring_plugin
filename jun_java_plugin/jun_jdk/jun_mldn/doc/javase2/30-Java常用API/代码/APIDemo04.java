public class APIDemo04
{
	public static void main(String args[]) throws Exception
	{
		Runtime r = Runtime.getRuntime() ;
		// ���г���
		Process p = r.exec("notepad.exe") ;
		Thread.sleep(3000) ;
		// �ý������� --> �ر�
		p.destroy() ;
	}
};