interface USB
{
	// ��ʼ����
	public void start() ;
	// ֹͣ����
	public void stop() ;
}
// ����PC�����ϵ���һ��USB�ӿ�
class PC
{
	public static void plugin(USB u) 
	{
		u.start() ;
		u.stop() ;
	}
};
class Mp3 implements USB
{
	public void start()
	{
		System.out.println("Mp3��ʼ�����ˡ�����") ;
	}
	public void stop()
	{
		System.out.println("Mp3ֹͣ�����ˡ�����") ;
	}
};

class UDisk implements USB
{
	public void start()
	{
		System.out.println("U�̿�ʼ�����ˡ�����") ;
	}
	public void stop()
	{
		System.out.println("U��ֹͣ�����ˡ�����") ;
	}
};

public class OODemo05
{
	public static void main(String args[])
	{
		PC.plugin(new UDisk()) ;
	}
};