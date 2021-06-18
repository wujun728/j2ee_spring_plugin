interface USB
{
	// ��ʼ����
	public void start() ;
	// ֹͣ����
	public void stop() ;
}
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
// ��������Ҫ�޸����࣬��Ҫ�޸�mian��������һ������Ŀͻ���
class Factory
{
	public static USB getUSBInstance()
	{
		return new UDisk() ;
	}
};
public class OODemo07
{
	public static void main(String args[])
	{
		USB u = Factory.getUSBInstance() ;
		u.start() ;
		u.stop() ;
	}
};
