class Login{	// �����Ĳ���������ʵ��ҵ�����
	private String args[] ; 
	public Login(String args[]){
		this.args = args ;
	}
	public boolean validate(){
		String name = this.args[0] ;	// ȡ���û���
		String password = this.args[1] ;	// ȡ������
		if(name.equals("abc")&&password.equals("123")){
			return true ;
		}else{
			return false ;
		}
	}
};
public class LoginDemo03{
	public static void main(String args[]){
		if(args.length!=2){
			System.out.println("����Ĳ�������ȷ��") ;
			System.exit(1) ;	// ϵͳ�˳���ֻҪ������һ�����������
		}
		System.out.println(new Login(args).validate()?"��½�ɹ���":"��½ʧ�ܣ�") ;
	}
};