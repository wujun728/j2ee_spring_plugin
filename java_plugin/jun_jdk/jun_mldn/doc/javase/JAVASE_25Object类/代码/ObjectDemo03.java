interface National{}
class Person extends Object implements National{
};
public class ObjectDemo03{
	public static void main(String arg[]){
		National na = new Person() ;	// ����Ϊ�ӿ�ʵ����
		Object obj = na ;	// ʹ��Object���սӿ�ʵ��
		National temp = (National)obj ;
	}
};