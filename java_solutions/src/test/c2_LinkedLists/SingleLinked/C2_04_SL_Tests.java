package test.c2_LinkedLists.SingleLinked;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Implementation.c2_LinkedLists.SinglyLinked.C2_04_SL;
import template.c2_LinkedLists.SinglyLinked.LinkedList;
import template.c2_LinkedLists.SinglyLinked.Node;


public class C2_04_SL_Tests {
	private C2_04_SL C2_04Obj;
	private LinkedList linkedList;

	@Before
	public void setUp() {
		C2_04Obj = new C2_04_SL();
		linkedList = new LinkedList();
	}
	
	@Test
	public void deleteMiddleNode1() {
		//Arrange
		int partition = 5;
		linkedList.insert(3);
		linkedList.insert(5);
		linkedList.insert(8);
		linkedList.insert(5);
		linkedList.insert(10);
		linkedList.insert(2);
		linkedList.insert(1);
		
		//Act
		C2_04Obj.partition(linkedList.getHead(),partition);
		
		//Assert
		System.out.println("Result was: " + linkedList.toString());
		Assert.assertTrue(checkResults(partition));
	}

	@Test
	public void deleteMiddleNode2() {
		//Arrange
		int partition = 5;
		linkedList.insert(3);
		linkedList.insert(5);
		linkedList.insert(8);
		linkedList.insert(5);
		linkedList.insert(10);
		linkedList.insert(2);
		linkedList.insert(19);

		//Act
		C2_04Obj.partition(linkedList.getHead(),partition);

		//Assert
		System.out.println("Result was: " + linkedList.toString());
		Assert.assertTrue(checkResults(partition));
	}

	@Test
	public void deleteMiddleNode3() {
		//Arrange
		int partition = -1;
		linkedList.insert(3);
		linkedList.insert(5);
		linkedList.insert(8);
		linkedList.insert(5);
		linkedList.insert(10);
		linkedList.insert(2);
		linkedList.insert(19);

		//Act
		C2_04Obj.partition(linkedList.getHead(),partition);

		//Assert
		System.out.println("Result was: " + linkedList.toString());
		Assert.assertTrue(checkResults(partition));
	}

	@Test
	public void deleteMiddleNode4() {
		//Arrange
		int partition = 0;

		//Act
		C2_04Obj.partition(linkedList.getHead(),partition);

		//Assert
		System.out.println("Result was: " + linkedList.toString());
		Assert.assertTrue(checkResults(partition));
	}

	@Test
	public void deleteMiddleNode5() {
		//Arrange
		int partition = -1;
		linkedList.insert(3);

		//Act
		C2_04Obj.partition(linkedList.getHead(),partition);

		//Assert
		System.out.println("Result was: " + linkedList.toString());
		Assert.assertTrue(checkResults(partition));
	}

	@Test
	public void deleteMiddleNode6() {
		//Arrange
		int partition = 8;
		linkedList.insert(3);

		//Act
		C2_04Obj.partition(linkedList.getHead(),partition);

		//Assert
		System.out.println("Result was: " + linkedList.toString());
		Assert.assertTrue(checkResults(partition));
	}

	@Test
	public void deleteMiddleNode9() {
		//Arrange
		int partition = 8;
		linkedList.insert(3);
		linkedList.insert(9);

		//Act
		C2_04Obj.partition(linkedList.getHead(),partition);

		//Assert
		System.out.println("Result was: " + linkedList.toString());
		Assert.assertTrue(checkResults(partition));
	}

	public boolean checkResults(int partition){
		boolean lessThan = true;
		Node current = linkedList.getHead();
		while(current!=null){
			//after first high value make sure no more low values are allowed
			if(current.getVal()>=partition){
				lessThan =false;
			}

			//In second partition no value should be less than
			if(!lessThan){
				if(current.getVal()<partition){
					return false;
				}
			}
			current=current.getNext();
		}
		return true;
	}
	@After
	public void tearDown() {
		C2_04Obj = null;
		linkedList =null;
	}
}
