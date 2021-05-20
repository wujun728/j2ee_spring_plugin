class Link{
	class Node{
		private String name ;
		private Node next ;	// ��������ÿ���ڵ�ָ����һ���ڵ�
		public Node(String name){
			this.name = name ;		// ͨ�����췽��Ϊname���Ը�ֵ
		}
		public void addNode(Node newNode){	// ���ӽڵ�
			if(this.next==null){
				this.next = newNode ;	// ����ڵ�
			}else{
				this.next.addNode(newNode) ;	// �������²���
			}
		}
		public void printNode(){	// ����ڵ�
			System.out.println(this.name) ;
			if(this.next!=null){	// �˽ڵ�֮�󻹴��������Ľڵ�
				this.next.printNode() ;
			}
		}
	};
	private Node root ;	// �����ͷ
	public void add(String name){	// ���ӽڵ�
		Node newNode = new Node(name) ;	// ����һ���µĽڵ�
		/*
			����ǵ�һ���ڵ㣬��϶��Ǹ��ڵ㣬
			����ǵڶ����ڵ㣬��϶����ڸ��ڵ�next��
			����ǵ������ڵ㣬��϶����ڵڶ����ڵ��next��
		*/ 
		if(this.root == null){
			this.root = newNode ;	// ����һ���ڵ����óɸ��ڵ�
		}else{
			// �϶�Ҫ�������һ���ڵ�֮��
			// ͨ���ڵ�.next�����ϵ��ж�
			this.root.addNode(newNode) ; 
		}
	}
	public void print(){
		if(this.root!=null){	// ������ڵ�Ϊ���ˣ���û���κ�����
			this.root.printNode() ;
		}
	}
};
public class LinkDemo{
	public static void main(String args[]){
		Link link = new Link() ;
		link.add("A") ;
		link.add("B") ;
		link.add("C") ;
		link.add("D") ;
		link.add("E") ;
		link.print() ;
	}
};