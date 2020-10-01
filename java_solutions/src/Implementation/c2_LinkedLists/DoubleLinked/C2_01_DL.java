package Implementation.c2_LinkedLists.DoubleLinked;

import java.util.HashSet;
import java.util.Set;

/**
 * Chapter 2 - Linked List
 * Problem: 2.1 Remove Dups:
 * <p>
 * Question:
 * Write code to remove duplicates from an unsorted linked list
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * <p>
 * Param:
 * Head of Double Linked List
 */
public class C2_01_DL {
    public void removeDups(DoubleLinkedList list) {
        Set<Character> found = new HashSet<>();
        DllNode current = list.head;
        DllNode prev = null;

        if(current!=null){
            found.add(current.getVal());
            prev = current;
            current = current.getNext();
        }

        while (current != null) {
            if (found.contains(current.getVal())) {
                prev.setNext(current.getNext());
                if(current.getNext()!=null){
                    current.getNext().setPrev(prev);
                }
            } else {
                found.add(current.getVal());
            }
            prev = current;
            current = current.getNext();
        }
    }
}
