package Implementation.c2_LinkedLists.SinglyLinked;

import template.c2_LinkedLists.SinglyLinked.Node;


public class C2_02_SL {

	public Node removeKthLast(Node head, int k) {
		int count = 0;
		Node current = head;

		while (current != null) {
			count++;
			current = current.getNext();
		}

		if (k > count||k<1) {
			return null;
		}
		if (count == k) {
			return head;
		} else {
			count = count - k;
			current = head;
			while (count != 0) {
				current = current.getNext();
				count--;
			}
		}
		return current;
	}

}
