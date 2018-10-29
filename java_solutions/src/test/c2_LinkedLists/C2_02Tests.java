package test.c2_LinkedLists;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import c2_LinkedLists.Node;

public class C2_02Tests {
	private c2_LinkedLists.C2_02 C2_02Obj;
	
	@BeforeMethod
	public void setUp() {
		C2_02Obj = new c2_LinkedLists.C2_02();
	}
	
	@Test
	public void removeKthLastTest1() {
		//tet no elements in list
		//Arrange
		Node expected = null;
		
		//Act
		Node actual = C2_02Obj.removeKthLast(3);
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest2() {
		//Test k greater than number elemenets
		//Arrange
		C2_02Obj.linkedList.insert(1);
		Node expected = null;
		
		//Act
		Node actual = C2_02Obj.removeKthLast(3);
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest3() {
		//Test only one element
		//Arrange
		C2_02Obj.linkedList.insert(1);
		int expected = 1;
		
		//Act
		int actual = C2_02Obj.removeKthLast(1).getVal();
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	
	@Test
	public void removeKthLastTest4() {
		//Test get first element 
		//Arrange
		C2_02Obj.linkedList.insert(1);
		C2_02Obj.linkedList.insert(2);
		C2_02Obj.linkedList.insert(3);
		C2_02Obj.linkedList.insert(4);
		int expected = 1;
		
		//Act
		int actual = C2_02Obj.removeKthLast(4).getVal();
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest5() {
		//Test get random element 
		//Arrange
		C2_02Obj.linkedList.insert(1);
		C2_02Obj.linkedList.insert(2);
		C2_02Obj.linkedList.insert(3);
		C2_02Obj.linkedList.insert(4);
		int expected = 2;
		
		//Act
		int actual = C2_02Obj.removeKthLast(3).getVal();
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest6() {
		//Test get last element 
		//Arrange
		C2_02Obj.linkedList.insert(1);
		C2_02Obj.linkedList.insert(2);
		C2_02Obj.linkedList.insert(3);
		C2_02Obj.linkedList.insert(4);
		int expected = 4;
		
		//Act
		int actual = C2_02Obj.removeKthLast(1).getVal();
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeKthLastTest7() {
		//Test get illegal element 0
		//Arrange
		C2_02Obj.linkedList.insert(1);
		C2_02Obj.linkedList.insert(2);
		C2_02Obj.linkedList.insert(3);
		C2_02Obj.linkedList.insert(4);
		Node expected = null;
		
		//Act
		Node actual = C2_02Obj.removeKthLast(-20);
		
		//Assert
		Assert.assertEquals(actual, expected);
	}
	@AfterMethod
	public void tearDown() {
		
	}
	
	
}
