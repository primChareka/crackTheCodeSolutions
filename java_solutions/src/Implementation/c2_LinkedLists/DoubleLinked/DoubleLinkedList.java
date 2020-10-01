package Implementation.c2_LinkedLists.DoubleLinked;

import java.util.Objects;

/**
 * Chapter 2 - Linked List
 * Problem: 2.
 */
public class DoubleLinkedList {
    DllNode head = null;
    DllNode tail = null;

    public void insert(char val) {
        if (head == null) {
            head = new DllNode(null, val);
        } else if (tail == null) {
            tail = new DllNode(head, val);
            head.setNext(tail);
        } else {
            DllNode node = new DllNode(tail, val);
            tail.setNext(node);
            tail = node;
        }
    }

    public void remove(DllNode node) {
        if (node == head) {
            head = node.getNext();
            node.getNext().setPrev(null);
        } else if (node == tail) {
            node.getPrev().setNext(null);
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }

    @Override
    public String toString() {
        StringBuilder builderCurrent = new StringBuilder();

        DllNode current = head;
        if (current != null) {
            builderCurrent
                    .append("{").append(current.getPrev() == null ? null : current.getPrev().getVal())
                    .append("->").append(current.getVal())
                    .append("->").append(current.getNext() == null ? null : current.getNext().getVal()).append("}");

            while (current.getNext() != null) {
                current = current.getNext();
                builderCurrent
                        .append(", {").append(current.getPrev().getVal())
                        .append("->").append(current.getVal())
                        .append("->").append(current.getNext() == null ? null : current.getNext().getVal()).append("}");

            }
        }
        return builderCurrent.toString();
    }
}
