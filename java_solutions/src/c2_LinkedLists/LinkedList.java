package c2_LinkedLists;

import c2_LinkedLists.Node;

public class LinkedList {
	private Node head;
	
	public void insert(int val) {
		if (head == null) {
			head = new Node(val);
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(new Node(val));
		}
	}// insert
	
	public Node getHead() {
		return this.head;
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
