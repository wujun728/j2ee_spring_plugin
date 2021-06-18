import java.util.* ;

interface Book
{
	// ��ļ۸�������֡������Ϣ
	public float getPrice() ;
	public String getName() ;
	public String getInfo() ;
}

class ChildBook implements Book
{
	private String name ;
	private float price ;
	private String info ;

	public ChildBook(String name,float price,String info)
	{
		this.setName(name) ;
		this.setPrice(price) ;
		this.setInfo(info) ;
	}

	public String getName()
	{
		return this.name ;
	}
	public float getPrice()
	{
		return this.price ;
	}
	public String getInfo()
	{
		return this.info ;
	}
	public void setName(String name)
	{
		this.name = name ;
	}
	public void setPrice(float price)
	{
		this.price = price ;
	}
	public void setInfo(String info)
	{
		this.info = info ;
	}
	public String toString()
	{
		return "��ͯ�飺������"+this.getName()+"���۸�"+this.price+"����飺"+this.getInfo() ;
	}
};

class ComputerBook implements Book
{
	private String name ;
	private float price ;
	private String info ;

	public ComputerBook(String name,float price,String info)
	{
		this.setName(name) ;
		this.setPrice(price) ;
		this.setInfo(info) ;
	}

	public String getName()
	{
		return this.name ;
	}
	public float getPrice()
	{
		return this.price ;
	}
	public String getInfo()
	{
		return this.info ;
	}
	public void setName(String name)
	{
		this.name = name ;
	}
	public void setPrice(float price)
	{
		this.price = price ;
	}
	public void setInfo(String info)
	{
		this.info = info ;
	}
	public String toString()
	{
		return "�����飺������"+this.getName()+"���۸�"+this.price+"����飺"+this.getInfo() ;
	}
};

class BookShop
{
	private String name ;
	// һ��������������
	private List allBooks ;

	public BookShop()
	{
		this.allBooks = new ArrayList() ;
	}
	public BookShop(String name)
	{
		this() ;
		this.setName(name) ;
	}

	// �õ�ȫ������
	public List getAllBooks()
	{
		return this.allBooks ;
	}

	public void append(Book book)
	{
		this.allBooks.add(book) ;
	}

	public void delete(Book book)
	{
		this.allBooks.remove(book) ;
	}

	// ����������֣�ȥ�ҵ�һ����
	public Book findByName(String name)
	{
		// �����е������н������β�ѯ
		Book book = null ;
		Iterator iter = this.allBooks.iterator() ;
		while(iter.hasNext())
		{
			// �������εıȽ�
			Book temp = (Book)iter.next() ;
			if(name.equals(temp.getName()))
			{
				// ���������ȣ����ʾ�ҵ���
				book = temp ;
				break ;
			}
		}
		return book ;
	}

	// ��ļ��������ģ����ѯ
	public List index(String keyWord)
	{
		List l = new ArrayList() ;

		Iterator iter = this.allBooks.iterator() ;
		while(iter.hasNext())
		{
			Book b = (Book)iter.next() ;
			if(b.getName().indexOf(keyWord)!=-1)
			{
				l.add(b) ;
			}
		}

		return l ;
	}

	public void setName(String name)
	{
		this.name = name ;
	}
	public String getName()
	{
		return this.name ;
	}
};

public class ColDemo01
{
	public static void main(String args[])
	{
		Book b1 = new ChildBook("һǧ��һҹ",10.0f,"һЩ��˵����") ;
		Book b2 = new ChildBook("С���Դ����",20.0f,"һ����ֵ�����") ;
		Book b3 = new ChildBook("HALIBOTE",25.0f,"ħ�ù���") ;
		Book b4 = new ComputerBook("JAVA",65.0f,"JAVA ���Եĺ��ļ���") ;
		Book b5 = new ComputerBook("C++",50.0f,"C++ ���Եĺ��ļ���") ;
		Book b6 = new ComputerBook("Linux",50.0f,"�������") ;

		BookShop bs = new BookShop("MLDN �������") ;
		bs.append(b1) ;
		bs.append(b2) ;
		bs.append(b3) ;
		bs.append(b4) ;
		bs.append(b5) ;
		bs.append(b6) ;

		// print(bs.getAllBooks()) ;
		// print(bs.index("A")) ;
		// ���轫C++�Ȿ������ɾ����
		Book b = bs.findByName("C++") ;
		// System.out.println(b) ;
		bs.delete(b) ;
		print(bs.getAllBooks()) ;
	}
	public static void print(List all)
	{
		Iterator iter = all.iterator() ;
		while(iter.hasNext())
		{
			Book b = (Book)iter.next() ;
			System.out.println(b) ;
		}
	}
};
