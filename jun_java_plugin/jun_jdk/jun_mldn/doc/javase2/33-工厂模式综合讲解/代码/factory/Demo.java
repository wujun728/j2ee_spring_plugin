import java.io.* ;
import java.util.* ;
public class Demo
{
	public static void main(String args[]) throws Exception
	{
		Properties p = new Properties() ;
		/*
		p.setProperty("a","org.lxh.demo.Apple") ;
		p.setProperty("o","org.lxh.demo.Orange") ;
		p.setProperty("b","org.lxh.demo.Banana") ;
		p.setProperty("c","org.lxh.demo.Cherry") ;
		// ���ļ��б���һ�����ݣ�������Ϊ���ϵ���������
		p.storeToXML(new FileOutputStream("lxh.xml"),"MLDN --> LXH") ;
		*/
		// ��Ҫ���ļ��ж�ȡҪProperties�е�����
		p.loadFromXML(new FileInputStream("lxh.xml")) ;
		System.out.println(p) ;
	}
};