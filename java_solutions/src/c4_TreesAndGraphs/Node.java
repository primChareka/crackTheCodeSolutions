package c4_TreesAndGraphs;

import java.util.ArrayList;

public class Node {
	public int val;
	public Node[] children;
	
	public Node(int val) {
		this.val = val;
		children = new Node[2];
	}
	
	public void printInOrder(ArrayList<Integer> result) {		
		if(getLeft()!=null) {
			getLeft().printInOrder(result);
		}
		
		System.out.println(val);
		result.add(val);
		
		
		if(getRight()!=null) {
			getRight().printInOrder(result);
		}	
	}
	
	public void printPreOrder(ArrayList<Integer> result) {
		System.out.println(val);
		result.add(val);
		
		if(getLeft()!=null) {
			getLeft().printPreOrder(result);
		}
		
		if(getRight()!=null) {
			getRight().printPreOrder(result);
		}
		
	}
	/**
	 * Takes an empty ArrayList of Integers and after printing each integer, add the printed item to the array
	 * 
	*/
	public void printPostOrder(ArrayList<Integer> result) {
		if(getLeft()!=null) {
			getLeft().printPostOrder(result);
		}
		
		if(getRight()!=null) {
			getRight().printPostOrder(result);
		}

		System.out.println(val);
		result.add(val);
	}
	
	public void printBreadthFirst()
	
	
	
	public void insertLeft(int val) {
		Node newNode = new Node(val);
		this.children[0] = newNode;
	}
	
	public void insertRight(int val) {
		Node newNode = new Node(val);
		this.children[1] = newNode;
	}
	
	public Node getLeft() {
		return this.children[0];
	}
	
	public Node getRight() {
		return this.children[1];
	}
}
