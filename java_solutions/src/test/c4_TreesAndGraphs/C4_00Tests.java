package test.c4_TreesAndGraphs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class C4_00Tests {
	private template.c4_TreesAndGraphs.Node root;
	@Before
	public void setup() {
		template.c4_TreesAndGraphs.Node temp;
		root = new template.c4_TreesAndGraphs.Node(15);
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
	public void printBreadthFirstTest() {
		ArrayList<template.c4_TreesAndGraphs.Node> result = new ArrayList<template.c4_TreesAndGraphs.Node>();
		ArrayList<Integer> actual = new ArrayList<Integer>();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(15);
		expected.add(9);
		expected.add(7);
		expected.add(4);
		expected.add(19);
		expected.add(12);
		expected.add(5);
		expected.add(3);
		root.printBreadthFirst(result);
		
		while(!result.isEmpty()) {
			actual.add(result.remove(0).getVal());
		}
		Assert.assertEquals(actual, expected);
		System.out.println();
	}
	
	@Test
	public void printDepthFirstTest() {
		ArrayList<template.c4_TreesAndGraphs.Node> result = new ArrayList<template.c4_TreesAndGraphs.Node>();
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
		root.printDepthFirst(result);
		
		while(!result.isEmpty()) {
			actual.add(result.remove(0).getVal());
		}
		Assert.assertEquals(actual, expected);
		System.out.println();
	}
	
	
	@Test
	public void printInorderTest1() {
		ArrayList<template.c4_TreesAndGraphs.Node> result = new ArrayList<template.c4_TreesAndGraphs.Node>();
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
		
		root.printInOrder(result);
		while(!result.isEmpty()) {
			actual.add(result.remove(0).getVal());
		}
		Assert.assertEquals(actual, expected);
		System.out.println();
	
	}
	
	@Test
	public void printPreOrderTest1() {
		ArrayList<template.c4_TreesAndGraphs.Node> result = new ArrayList<template.c4_TreesAndGraphs.Node>();
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
		
		root.printPreOrder(result);
		while(!result.isEmpty()) {
			actual.add(result.remove(0).getVal());
		}
		Assert.assertEquals(actual, expected);
		System.out.println();
	
	}
	
	@Test
	public void printInorderTest3() {
		ArrayList<template.c4_TreesAndGraphs.Node> result = new ArrayList<template.c4_TreesAndGraphs.Node>();
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
		root.printPostOrder(result);
		
		while(!result.isEmpty()) {
			actual.add(result.remove(0).getVal());
		}
		Assert.assertEquals(actual, expected);
		System.out.println();
	
	}
	
	@After
	public void tearDown(){
		root = null;
	}
}
