package test.c2_LinkedLists.DoubleLinked;

import Implementation.c2_LinkedLists.DoubleLinked.C2_01_DL;
import Implementation.c2_LinkedLists.DoubleLinked.DoubleLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import template.c2_LinkedLists.SinglyLinked.C2_01_SL;

public class C2_01Tests {
	private C2_01_SL C2_01_Obj;
	private C2_01_DL c2_01_dl_obj;
	private DoubleLinkedList doubleLinkedList;
	private DoubleLinkedList expectedList;
	
	@Before
	public void setup() {
		c2_01_dl_obj = new C2_01_DL();
		doubleLinkedList = new DoubleLinkedList();
		expectedList = new DoubleLinkedList();
	}
	
	@Test
	public void removeUnsortedTest() {
		doubleLinkedList.insert('a');
		doubleLinkedList.insert('b');
		doubleLinkedList.insert('b');
		doubleLinkedList.insert('c');
		doubleLinkedList.insert('c');
		doubleLinkedList.insert('d');
		
		c2_01_dl_obj.removeDups(doubleLinkedList);

		expectedList.insert('a');
		expectedList.insert('b');
		expectedList.insert('c');
		expectedList.insert('d');
	}
	
	@Test
	public void removeUnsortedNoBufferTest() {

	}
	@After
	public void tearDown(){
		c2_01_dl_obj = null;
		doubleLinkedList = null;
		expectedList = null;
	}
}
