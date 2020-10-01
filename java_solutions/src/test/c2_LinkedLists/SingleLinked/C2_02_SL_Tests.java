package test.c2_LinkedLists.SingleLinked;


import Implementation.c2_LinkedLists.SinglyLinked.C2_02_SL;
import template.c2_LinkedLists.SinglyLinked.LinkedList;
import template.c2_LinkedLists.SinglyLinked.Node;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class C2_02_SL_Tests {
	private C2_02_SL C2_02Obj;
	private LinkedList linkedList;
	
	@Before
	public void setUp() {
		C2_02Obj = new C2_02_SL();
		linkedList = new LinkedList();
	}
	
	@Test
	public void removeKthLastTest1() {
		//tet no elements in list
		//Arrange
		Node expected = null;
		
		//Act
		Node actual = C2_02Obj.removeKthLast(linkedList.getHead(), 3);
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest2() {
		//Test k greater than number elemenets
		//Arrange
		linkedList.insert(1);
		Node expected = null;
		
		//Act
		Node actual = C2_02Obj.removeKthLast(linkedList.getHead(),3);
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest3() {
		//Test only one element
		//Arrange
		linkedList.insert(1);
		int expected = 1;
		
		//Act
		int actual = C2_02Obj.removeKthLast(linkedList.getHead(),1).getVal();
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	
	@Test
	public void removeKthLastTest4() {
		//Test get first element 
		//Arrange
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		int expected = 1;
		
		//Act
		int actual = C2_02Obj.removeKthLast(linkedList.getHead(),4).getVal();
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest5() {
		//Test get random element 
		//Arrange
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		int expected = 2;
		
		//Act
		int actual = C2_02Obj.removeKthLast(linkedList.getHead(),3).getVal();
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest6() {
		//Test get last element 
		//Arrange
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		int expected = 4;
		
		//Act
		int actual = C2_02Obj.removeKthLast(linkedList.getHead(), 1).getVal();
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest7() {
		//Test get illegal element 0
		//Arrange
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		Node expected = null;
		
		//Act
		Node actual = C2_02Obj.removeKthLast(linkedList.getHead(),-20);
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	@After
	public void tearDown() {
		
	}
	
	
}
