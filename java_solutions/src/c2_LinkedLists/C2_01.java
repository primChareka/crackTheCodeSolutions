package c2_LinkedLists;

import java.util.HashSet;

public class C2_01 {

	//public Node head;
	public LinkedList linkedList = new LinkedList();
	
	public void removeUnsorted() {
		HashSet<Integer> values = new HashSet<Integer>();
		Node current;
		Node head = linkedList.getHead();

		if (head == null) {
			return;
		}
		current = head;
		values.add(current.getVal());

		// 1,2,3,3,2,5
		while (current.getNext() != null) {
			// if getVal()ues is in hashset remove node from list
			if (values.contains(current.getNext().getVal())) {
				current.setNext(current.getNext().getNext());
			} else {
				// else add getVal()ue to set
				values.add(current.getNext().getVal());
				current = current.getNext();
			} // end if

		} // end while
	}

	public void removeUnsortedNoBuffer() {
		Node current;
		Node runner;
		Node head = linkedList.getHead();
		if (head == null) {
			return;
		} else {
			// 1,2,1,3,4
			current = head;
			runner = current;
			while (current.getNext() != null) {
				// runner = current.getNext();
				while (runner.getNext() != null) {
					if (runner.getNext().getVal() == current.getVal()) {
						runner.setNext(runner.getNext().getNext());
					} else {
						runner = runner.getNext();
					}
				}
			}

		}

	}

	public void insert(int val) {
		Node head = linkedList.getHead();
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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node current = linkedList.getHead();

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
