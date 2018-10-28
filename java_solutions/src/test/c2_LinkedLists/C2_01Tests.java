package test.c2_LinkedLists;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C2_01Tests {
	private c2_LinkedLists.C2_01 linkedList;
	
	@BeforeMethod
	public void setup() {
		 linkedList = new c2_LinkedLists.C2_01();
	}
	
	@Test
	public void insertAndPrintTest() {
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		
		String expected = "[1->2->3]";
		
		String actual = linkedList.toString();
		
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void printEmptyTest() {
		String expected = "[]";
		String actual = linkedList.toString();
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeUnsortedTest() {
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(3);
		linkedList.insert(2);
		linkedList.insert(5);
		linkedList.insert(5);
		linkedList.insert(5);
		linkedList.insert(5);
		linkedList.insert(1);
		
		String expected = "[1->2->3->5]";
		
		linkedList.removeUnsorted();
		String actual = linkedList.toString();
		
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeUnsortedNoBufferTest() {
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(3);
		linkedList.insert(2);
		linkedList.insert(5);
		linkedList.insert(5);
		linkedList.insert(5);
		linkedList.insert(5);
		linkedList.insert(1);

		String expected = "[1->2->3->5]";
		
		linkedList.removeUnsorted();
		String actual = linkedList.toString();
		
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	@AfterMethod 
	public void tearDown(){
		linkedList = null;
	}
}
