package cn.mldn.lxh.demo ;
public class Count {
	private int count = 0 ;
	public Count(){
		System.out.println("=========== һ���µ�Count������� ===========") ;
	}
	public int getCount(){
		return ++ this.count ;
	}
}