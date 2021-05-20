package org.lxh.demo ;
import java.io.* ;
import java.util.* ;
interface Fruit
{
	// ����
	public void grow() ;
	// ��ժ
	public void pick() ;
}
class Apple implements Fruit
{
	public void grow()
	{
		System.out.println("ƻ�������������� ") ;
	}
	public void pick()
	{
		System.out.println("ժƻ��������") ;
	}
};
class Orange implements Fruit
{
	public void grow()
	{
		System.out.println("���������������� ") ;
	}
	public void pick()
	{
		System.out.println("ժ���ӡ�����") ;
	}
};
class Cherry implements Fruit
{
	public void grow()
	{
		System.out.println("ӣ�������������� ") ;
	}
	public void pick()
	{
		System.out.println("ժӣ�ҡ�����") ;
	}
};

class WaterMelon implements Fruit
{
	public void grow()
	{
		System.out.println("����������������") ;
	}
	public void pick()
	{
		System.out.println("ժ���ϡ�����") ;
	}
};

class Banana implements Fruit
{
	public void grow()
	{
		System.out.println("�㽶������������ ") ;
	}
	public void pick()
	{
		System.out.println("ժ�㽶������") ;
	}
};

class DD implements Fruit
{
	public void grow()
	{
		System.out.println("DD������ ") ;
	}
	public void pick()
	{
		System.out.println("ժDD������") ;
	}
};

class Factory
{
	public static Fruit getFruitInstance(String type)
	{
		Fruit f = null ;
		// ͨ��Class�����
		try
		{
			f = (Fruit)Class.forName(type).newInstance() ;
		}
		catch (Exception e)
		{
			System.out.println(e) ;
		}
		return f ;
	}
};

// ����һ�����࣬������ԴӼ�����������
class InputData
{
	BufferedReader buf = null ;
	public InputData()
	{
		buf = new BufferedReader(new InputStreamReader(System.in)) ;
	}
	public String getString()
	{
		String str = null ;
		try
		{
			str = buf.readLine() ;
		}
		catch (Exception e)
		{
		}
		return str ;
	}
};

class Init
{
	public static Properties getPropertiesInit()
	{
		Properties p = new Properties() ;
		try
		{
			p.loadFromXML(new FileInputStream("lxh.xml")) ;
		}
		catch (Exception e)
		{
		}
		return p ;
	}
};

public class FactoryDemo06
{
	public static void main(String args[])
	{
		Properties p = new Properties() ;
		p = Init.getPropertiesInit() ;
		System.out.println(p) ;
		
		// ����һ�����ԴӼ����������ݵ���
		System.out.print("����Ҫʹ�õ�������룺") ;
		String code = new InputData().getString() ;
		System.out.println(p.getProperty(code)) ;
		Fruit f = Factory.getFruitInstance(p.getProperty(code)) ;
		if(f!=null)
		{
			f.grow() ;
			f.pick() ;
		}
		else
		{
			System.out.println("û�з���������͡�") ;
		}
	}
};