interface USB{
	public void start() ;	// ��ʼ����
	public void stop() ;	// ��������
}
class Computer{
	public static void plugin(USB usb){
		usb.start() ;
		usb.stop() ;
	}
};
class Flash implements USB{
	public void start(){
		System.out.println("U�̿�ʼ������") ;
	}
	public void stop(){
		System.out.println("U��ֹͣ������") ;
	}
};
class Print implements USB{
	public void start(){
		System.out.println("��ӡ����ʼ������") ;
	}
	public void stop(){
		System.out.println("��ӡ��ֹͣ������") ;
	}
};
public class InterPolDemo02{
	public static void main(String args[]){
		Computer.plugin(new Flash()) ;
		Computer.plugin(new Print()) ;
	}
};