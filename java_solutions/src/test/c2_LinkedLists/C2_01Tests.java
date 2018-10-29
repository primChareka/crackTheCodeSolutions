package test.c2_LinkedLists;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C2_01Tests {
	private c2_LinkedLists.C2_01 C2_01_Obj;
	
	@BeforeMethod
	public void setup() {
		C2_01_Obj = new c2_LinkedLists.C2_01();
	}
	
	@Test
	public void insertAndPrintTest() {
		C2_01_Obj.linkedList.insert(1);
		C2_01_Obj.linkedList.insert(2);
		C2_01_Obj.linkedList.insert(3);
		
		String expected = "[1->2->3]";
		
		String actual = C2_01_Obj.linkedList.toString();
		
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void printEmptyTest() {
		String expected = "[]";
		String actual = C2_01_Obj.linkedList.toString();
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeUnsortedTest() {
		C2_01_Obj.linkedList.insert(1);
		C2_01_Obj.linkedList.insert(2);
		C2_01_Obj.linkedList.insert(3);
		C2_01_Obj.linkedList.insert(3);
		C2_01_Obj.linkedList.insert(2);
		C2_01_Obj.linkedList.insert(5);
		C2_01_Obj.linkedList.insert(5);
		C2_01_Obj.linkedList.insert(5);
		C2_01_Obj.linkedList.insert(5);
		C2_01_Obj.linkedList.insert(1);
		
		String expected = "[1->2->3->5]";
		
		C2_01_Obj.removeUnsorted();
		String actual = C2_01_Obj.linkedList.toString();
		
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void removeUnsortedNoBufferTest() {
		C2_01_Obj.linkedList.insert(1);
		C2_01_Obj.linkedList.insert(2);
		C2_01_Obj.linkedList.insert(3);
		C2_01_Obj.linkedList.insert(3);
		C2_01_Obj.linkedList.insert(2);
		C2_01_Obj.linkedList.insert(5);
		C2_01_Obj.linkedList.insert(5);
		C2_01_Obj.linkedList.insert(5);
		C2_01_Obj.linkedList.insert(5);
		C2_01_Obj.linkedList.insert(1);

		String expected = "[1->2->3->5]";
		
		C2_01_Obj.removeUnsorted();
		String actual = C2_01_Obj.linkedList.toString();
		
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	@AfterMethod 
	public void tearDown(){
		C2_01_Obj = null;
	}
}
