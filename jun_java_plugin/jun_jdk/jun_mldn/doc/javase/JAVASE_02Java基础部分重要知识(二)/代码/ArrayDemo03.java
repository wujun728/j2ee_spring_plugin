public class ArrayDemo03{
	public static void main(String args[]){
		int i[][] = {{1,2},{2,3,4},{3,4,5,6,7}} ;	// ��ʱ���ھ�̬��ʼ��
		System.out.print("���鿪��֮������ݣ�") ;
		for(int x=0;x<i.length;x++){
			for(int y=0;y<i[x].length;y++){
				System.out.print(i[x][y] + "��") ;
			}
			System.out.println("") ;
		}
	}
};