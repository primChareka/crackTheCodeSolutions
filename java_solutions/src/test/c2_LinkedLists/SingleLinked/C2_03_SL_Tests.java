package test.c2_LinkedLists.SingleLinked;


import Implementation.c2_LinkedLists.SinglyLinked.C2_02_SL;
import Implementation.c2_LinkedLists.SinglyLinked.C2_03_SL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import template.c2_LinkedLists.SinglyLinked.LinkedList;
import template.c2_LinkedLists.SinglyLinked.Node;

public class C2_03_SL_Tests {
	private C2_03_SL C2_03Obj;
	private LinkedList linkedList;
	
	@Before
	public void setUp() {
		C2_03Obj = new C2_03_SL();
		linkedList = new LinkedList();
	}
	
	@Test
	public void deleteMiddleNode1() {
		//Arrange
		Node toRemove=null;
		linkedList.insert(1);
		linkedList.insert(2);
		toRemove=linkedList.getTail();
		linkedList.insert(3);
		
		//Act
		C2_03Obj.removeMiddleNode(toRemove);
		
		//Assert
		String expected = "[1->3]";
		Assert.assertEquals(expected,linkedList.toString());
	}

	@Test
	public void deleteMiddleNode2() {
		//Arrange
		Node toRemove=null;
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(2);
		toRemove=linkedList.getTail();
		linkedList.insert(3);

		//Act
		C2_03Obj.removeMiddleNode(toRemove);

		//Assert
		String expected = "[1->2->3]";
		Assert.assertEquals(expected,linkedList.toString());
	}

	@After
	public void tearDown() {
		
	}
	
	
}
