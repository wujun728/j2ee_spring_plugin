class Link{
	class Node{
		private String name ;	// ����ڵ������
		private Node next ;		// ������һ���ڵ�
		public Node(String name){
			this.name = name ;
		}
		public String getName(){
			return this.name ;
		}
		public void addNode(Node newNode){
			if(this.next==null){	// ����û�ж���
				this.next = newNode ;
			}else{
				this.next.addNode(newNode) ;	// ���¼�����
			}
		}
		public void printNode(){
			System.out.print(this.name + " --> " ) ;
			if(this.next!=null){
				this.next.printNode() ;	// ���¼����г�
			}
		}
		public boolean searchNode(String name){
			if(this.name.equals(name)){
				return true ;
			}else{
				if(this.next!=null){
					return this.next.searchNode(name) ;
				}else{
					return false ;
				}
			}
		}
		public void deleteNode(Node preNode,String name){
			if(this.name.equals(name)){
				preNode.next = this.next ;
			}else{
				this.next.deleteNode(this,name) ;
			}
		}
	};
	private Node root ;	// Ҫ��������ڵ�
	public void add(String name){
		Node newNode = new Node(name) ;
		if(this.root==null){	// û�и��ڵ㣬��ѵ�һ����Ϊ���ڵ�
			this.root = newNode ;
		}else{
			this.root.addNode(newNode) ;
		}
	}
	public void print(){
		if(this.root!=null){
			this.root.printNode() ;
		}
	}
	public boolean search(String name){	// ָ�����ҵ�����
		if(this.root!=null){
			return this.root.searchNode(name) ;
		}else{
			return false ;
		}
	}
	public void delete(String name){
		if(this.search(name)){	// �жϴ˽ڵ��Ƿ����
			if(this.root.name.equals(name)){
				if(this.root.next!=null){
					this.root = this.root.next ;	// �ı���ڵ�
				}else{
					this.root = null ;	// ȡ��
				}
			}else{
				if(this.root.next!=null){
					this.root.next.deleteNode(root,name) ;
				}
			}
		}
	}
};
public class LinkDemo02{
	public static void main(String args[]){
		Link link = new Link() ;
		link.add("���ڵ�") ;
		link.add("��һ�ڵ�") ;
		link.add("�ڶ��ڵ�") ;
		link.add("�����ڵ�") ;
		link.add("���Ľڵ�") ;
		link.add("����ڵ�") ;
		link.print() ;
		System.out.println() ;
		// System.out.println(link.search("��x�ڵ�")) ;
		link.delete("���Ľڵ�") ;
		link.delete("���ڵ�") ;
		link.print() ;
	}
};