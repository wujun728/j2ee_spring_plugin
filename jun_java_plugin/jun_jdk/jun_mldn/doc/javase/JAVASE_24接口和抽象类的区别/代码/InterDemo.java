interface Fruit{
	public void eat() ;
}
class Apple implements Fruit{
	public void eat(){
		System.out.println("��ƻ��������") ;
	}
};
class Orange implements Fruit{
	public void eat(){
		System.out.println("�����ӡ�����") ;
	}
};
class Factory{	// ������
	public static Fruit getFruit(String className){
		Fruit f = null ;
		if("apple".equals(className)){
			f = new Apple() ;
		}
		if("orange".equals(className)){
			f = new Orange() ;
		}
		return f ;
	}
};
public class InterDemo{
	public static void main(String args[]){
		Fruit f = Factory.getFruit(args[0]) ;
		if(f!=null){
			f.eat() ;
		}
	}
}