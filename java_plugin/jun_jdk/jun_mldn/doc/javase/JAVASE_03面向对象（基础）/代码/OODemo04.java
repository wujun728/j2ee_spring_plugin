class Person{
	String name	;	// ��ʾ�˵�����
	int age ;		// ��ʾ�˵�����
	public void tell(){	// ����˵���ķ���
		System.out.println("������" + name + "�����䣺" + age) ;
	}
};
public class OODemo04{
	public static void main(String args[]){
		Person per = null ;	// ��������
		per.name = "����" ;		// Ϊ���ָ�ֵ
		per.age = 30 ;			// Ϊ���丳ֵ
		per.tell() ;			// ���÷���
	}
};