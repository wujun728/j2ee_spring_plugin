class Student{
	private String name ;
	private int age ;
	private float english ;
	private float computer ;
	private float math ;
	public Student(){}
	public Student(String n,int a,float e,float c,float m){
		this.setName(n) ;
		this.setAge(a) ;
		this.setEnglish(e) ;
		this.setComputer(c) ;
		this.setMath(m) ;
	}
	public float sum(){
		return english + computer + math ;
	}
	public float avg(){
		return this.sum() / 3 ;
	}
	public float max(){
		float max = computer>math?computer:math ;
		max = max>english?max:english ;
		return max ;
	}
	public float min(){
		float min = computer<math?computer:math ;
		min = min<english?min:english ;
		return min ;
	}
	public String getInfo(){
		return	"ѧ����Ϣ�� \n" +
				"\t|- ������" + this.getName() + "\n" +
				"\t|- ���䣺" + this.getAge() + "\n" +
				"\t|- ��ѧ�ɼ���" + this.getMath() + "\n" +
				"\t|- Ӣ��ɼ���" + this.getEnglish() + "\n" +
				"\t|- ������ɼ���" + this.getComputer() ;
	}
	public void setName(String n){
		name = n ;
	}
	public void setAge(int a){
		age = a ;
	}
	public void setEnglish(float e){
		english = e ;
	}
	public void setComputer(float c){
		computer = c ;
	}
	public void setMath(float m){
		math = m ;
	}
	public String getName(){
		return name ;
	}
	public int getAge(){
		return age ;
	}
	public float getEnglish(){
		return english ;
	}
	public float getComputer(){
		return computer ;
	}
	public float getMath(){
		return math ;
	}
}
public class ExecDemo{
	public static void main(String args[]){
		Student stu = new Student("����",30,89.0f,91.0f,87.0f) ;
		System.out.println("�ܷ֣�" + stu.sum()) ;
		System.out.println("ƽ���֣�" + stu.avg()) ;
		System.out.println("��߷֣�" + stu.max()) ;
		System.out.println("��ͷ֣�" + stu.min()) ;
		System.out.println(stu.getInfo()) ;
	}
};