public class LoginDemo02{
	public static void main(String args[]){
		if(args.length!=2){
			System.out.println("����Ĳ�������ȷ��") ;
			System.exit(1) ;	// ϵͳ�˳���ֻҪ������һ�����������
		}
		String name = args[0] ;	// ȡ���û���
		String password = args[1] ;	// ȡ������
		if(name.equals("abc")&&password.equals("123")){
			System.out.println("��½�ɹ���") ;
		}else{
			System.out.println("��½ʧ�ܣ�") ;
		}
	}
};