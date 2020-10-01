package Implementation.c2_LinkedLists.DoubleLinked;

import java.util.Objects;

public class DllNode {
	private DllNode next;
	private DllNode prev;
	private char val;

	public DllNode(DllNode prev, char val) {
		this.val = val;
		this.prev = prev;
		this.next = null;
	}
	
	public DllNode getNext(){
		return this.next;
	}

	public DllNode getPrev() { return this.prev; }
	
	public char getVal() {
		return this.val;
	}
	
	public void setNext(DllNode next) {
		this.next=next;
	}

	public void setPrev(DllNode prev){this.prev=prev;}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DllNode dllNode = (DllNode) o;
		return val == dllNode.val &&
				Objects.equals(next, dllNode.next) &&
				Objects.equals(prev, dllNode.prev);
	}

	@Override
	public int hashCode() {
		return Objects.hash(next, prev, val);
	}
}
