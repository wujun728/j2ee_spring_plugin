class Login{	// �����Ĳ���������ʵ��ҵ�����
	private String name ;
	private String password ;
	public Login(String name,String password){
		this.name = name ;
		this.password = password ;
	}
	public boolean validate(){
		if(name.equals("abc")&&password.equals("123")){
			return true ;
		}else{
			return false ;
		}
	}
};
class Operate{
	private String args[] ;
	public Operate(String args[]){
		this.args = args ;
		if(args.length!=2){
			System.out.println("����Ĳ�������ȷ��") ;
			System.exit(1) ;	// ϵͳ�˳���ֻҪ������һ�����������
		}
	}
	public String getInfo(){
		if(new Login(this.args[0],this.args[1]).validate()){
			return "��½�ɹ���" ;
		}else{
			return "��½ʧ�ܣ�" ;
		}
	}
};
public class LoginDemo04{
	public static void main(String args[]){
		System.out.println(new Operate(args).getInfo()) ;
	}
};