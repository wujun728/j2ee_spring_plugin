public class LoginDemo01{
	public static void main(String args[]){
		String name = args[0] ;	// ȡ���û���
		String password = args[1] ;	// ȡ������
		if(name.equals("abc")&&password.equals("123")){
			System.out.println("��½�ɹ���") ;
		}else{
			System.out.println("��½ʧ�ܣ�") ;
		}
	}
};