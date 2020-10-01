package test.c2_LinkedLists.SingleLinked;

import Implementation.c2_LinkedLists.SinglyLinked.C2_01_SL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class C2_01_SL_Tests {
	private C2_01_SL C2_01_Obj;
	
	@Before
	public void setup() {
		C2_01_Obj = new C2_01_SL();
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
		
		C2_01_Obj.removeDupsUnsorted();
		String actual = C2_01_Obj.linkedList.toString();
		
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
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
		
		C2_01_Obj.removeDupsUnsorted();
		String actual = C2_01_Obj.linkedList.toString();
		
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}

	@After
	public void tearDown(){
		C2_01_Obj = null;
	}
}
