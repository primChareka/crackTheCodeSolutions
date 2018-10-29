package c2_LinkedLists;

public class Node {
	private Node next;
	private int val;

	public Node(int val) {
		this.val = val;
		next = null;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public int getVal() {
		return this.val;
	}
	
	public void setNext(Node next) {
		this.next=next;
	}
}
