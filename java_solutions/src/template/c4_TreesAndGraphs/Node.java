package template.c4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node {
	public int val;
	public Node[] children;
	public static Queue<Node> queue = new LinkedList<Node>();
	public static Stack<Node> stack = new Stack<Node>();

	public Node(int val) {
		this.val = val;
		children = new Node[2];
	}

	public void printInOrder(ArrayList<Node> result) {
		if (getLeft() != null) {
			getLeft().printInOrder(result);
		}

		System.out.println(val);
		result.add(this);

		if (getRight() != null) {
			getRight().printInOrder(result);
		}
	}

	public void printPreOrder(ArrayList<Node> result) {
		System.out.println(val);
		result.add(this);

		if (getLeft() != null) {
			getLeft().printPreOrder(result);
		}

		if (getRight() != null) {
			getRight().printPreOrder(result);
		}

	}

	/**
	 * Takes an empty ArrayList of Nodes and after printing each integer, add the
	 * printed Node to the array
	 */
	public void printPostOrder(ArrayList<Node> result) {
		if (getLeft() != null) {
			getLeft().printPostOrder(result);
		}

		if (getRight() != null) {
			getRight().printPostOrder(result);
		}

		System.out.println(val);
		result.add(this);
	}

	public void printBreadthFirst(ArrayList<Node> result) {
		System.out.println(val);
		result.add(this);
		
		if(getLeft()!=null) {
			queue.add(getLeft());
		}
		
		if(getRight()!=null) {
			queue.add(getRight());
		}

		if (queue.peek() != null) {		
			queue.remove().printBreadthFirst(result);
		}	
	}

	
	public void printDepthFirst(ArrayList<Node> result) {
		System.out.println(val);
		result.add(this);
		
		if(getRight()!=null) {
			stack.push(getRight());
		}
		
		if(getLeft()!=null) {
			stack.push(getLeft());
		}
		
		if(!stack.isEmpty()){
			stack.pop().printDepthFirst(result);
		}
	}
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
	
	public int getVal() {
		return this.val;
	}

	public int getNumChildren() {
		return children.length;
	}
}
