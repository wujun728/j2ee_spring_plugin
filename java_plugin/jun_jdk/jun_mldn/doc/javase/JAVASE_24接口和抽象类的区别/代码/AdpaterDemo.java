interface Window{
	public void open() ;	// �򿪴���
	public void close() ;	// �رմ���
	public void icon() ;	// ��С��
	public void unicon() ;	// ���
}
abstract class WindowAdapter implements Window{
	public void open(){}
	public void close(){}
	public void icon(){}
	public void unicon(){}
};
class MyWindow extends WindowAdapter{
	public void open(){
		System.out.println("�򿪴��ڣ�") ;
	}
};
public class AdpaterDemo{
	public static void main(String args[]){
		Window win = new MyWindow() ;
		win.open() ;
	}
}