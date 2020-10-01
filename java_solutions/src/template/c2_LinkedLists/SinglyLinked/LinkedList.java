package template.c2_LinkedLists.SinglyLinked;

public class LinkedList {
	private Node head;
	private Node tail;
	
	public void insert(int val) {
		if (head == null) {
			head = new Node(val);
			tail=head;
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(new Node(val));
			tail = current.getNext();
		}
	}// insert

	public Node getHead() {
		return this.head;
	}

	public Node getTail() {
		return this.tail;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		Node current = head;

		result.append("[");
		while (current != null) {
			if (current.getNext() == null) {
				result.append(current.getVal());
			} else {
				result.append(current.getVal() + "->");
			}
			current = current.getNext();
		}
		result.append("]");

		return result.toString();
	}
}
