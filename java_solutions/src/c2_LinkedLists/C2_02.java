package c2_LinkedLists;

import java.util.HashSet;

public class C2_02 {

	public LinkedList linkedList = new LinkedList();

	public Node removeKthLast(int k) {
		int count = 0;
		Node current = linkedList.getHead();

		while (current != null) {
			count++;
			current = current.getNext();
		}

		if (k > count||k<1) {
			return null;
		}
		if (count == k) {
			return linkedList.getHead();
		} else {
			count = count - k;
			current = linkedList.getHead();
			while (count != 0) {
				current = current.getNext();
				count--;
			}
		}
		return current;
	}

}
