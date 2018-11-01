package test.c4_TreesAndGraphs;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C4_00Tests {
	private c4_TreesAndGraphs.Node root;
	@BeforeMethod
	public void setup() {
		c4_TreesAndGraphs.Node temp;
		root = new c4_TreesAndGraphs.Node(15);
		root.insertLeft(9);
		root.insertRight(7);
		
		temp = root.getLeft();
		temp.insertLeft(4)
		;
		temp = temp.getLeft();
		temp.insertLeft(5);
		temp.insertRight(3);
		
		temp = root.getRight();
		temp.insertLeft(19);
		temp.insertRight(12);
		/*
		 * 							15
		 * 				9						7
		 *		4				o		19				12
		 *	5		3
		 */
	}
	
	
	@Test
	public void printInorderTest1() {
		ArrayList<Integer> actual = new ArrayList<Integer>();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(5);
		expected.add(4);
		expected.add(3);
		expected.add(9);
		expected.add(15);
		expected.add(19);
		expected.add(7);
		expected.add(12);
		
		root.printInOrder(actual);
		Assert.assertEquals(actual, expected);
		System.out.println();
	
	}
	
	@Test
	public void printPreOrderTest1() {
		ArrayList<Integer> actual = new ArrayList<Integer>();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(15);
		expected.add(9);
		expected.add(4);
		expected.add(5);
		expected.add(3);
		expected.add(7);
		expected.add(19);
		expected.add(12);
		root.printPreOrder(actual);
		Assert.assertEquals(actual, expected);
		System.out.println();
	
	}
	
	@Test
	public void printInorderTest3() {
		ArrayList<Integer> actual = new ArrayList<Integer>();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(5);
		expected.add(3);
		expected.add(4);
		expected.add(9);
		expected.add(19);
		expected.add(12);
		expected.add(7);
		expected.add(15);
		root.printPostOrder(actual);
		Assert.assertEquals(actual, expected);
		
		System.out.println();
		
		
	
	}
	
	@AfterMethod
	public void tearDown(){
		root = null;
	}
}