package Implementation.c2_LinkedLists.SinglyLinked;

import template.c2_LinkedLists.SinglyLinked.LinkedList;
import template.c2_LinkedLists.SinglyLinked.Node;

import java.util.HashSet;


public class C2_01_SL {

	public LinkedList linkedList = new LinkedList();

	public void removeDupsUnsorted() {
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

	public void removeDupsUnsortedNoBuffer() {
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
}
