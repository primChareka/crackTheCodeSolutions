package c2_LinkedLists;

import java.util.HashSet;
import java.util.LinkedList;

public class C2_01 {

	public Node head;

	public void removeUnsorted() {
		HashSet<Integer> values = new HashSet<Integer>();
		Node current;

		if (head == null) {
			return;
		}
		current = head;
		values.add(current.val);

		// 1,2,3,3,2,5
		while (current.next != null) {
			// if values is in hashset remove node from list
			if (values.contains(current.next.val)) {
				current.next = current.next.next;
			} else {
				// else add value to set
				values.add(current.next.val);
				current = current.next;
			} // end if

		} // end while
	}

	public void removeUnsortedNoBuffer() {
		Node current;
		Node runner;
		if (head == null) {
			return;
		} else {
			// 1,2,1,3,4
			current = head;
			runner = current;
			while (current.next != null) {
				// runner = current.next;
				while (runner.next != null) {
					if (runner.next.val == current.val) {
						runner.next = runner.next.next;
					} else {
						runner = runner.next;
					}
				}
			}

		}

	}

	public void insert(int val) {
		if (head == null) {
			head = new Node(val);
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}

			current.next = new Node(val);
		}
	}// insert

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node current = head;

		result.append("[");
		while (current != null) {
			if (current.next == null) {
				result.append(current.val);
			} else {
				result.append(current.val + "->");
			}
			current = current.next;
		}
		result.append("]");

		return result.toString();
	}

	public class Node {
		Node next;
		int val;

		public Node(int val) {
			this.val = val;
			next = null;
		}
	}

}
