/**
 * Cracking-The-Coding-Interview
 * Chapter 1 - Arrays and Strings
 * Q1_02.java
 * 
 * Question:
 * There are three types of edits that can be performed
 * on strings, insert a character, remove a character or
 * replace a character. Given two strings, write a function
 * to check of they are one edit (or zero edits) away.
 * 
 * EXAMPLE
 * Input: pale, ple
 * Output: true
 * 
 * Input: pales, pale
 * Output: true
 * 
 * Input: pale, bale
 * Output: true
 * 
 * Input: pale, bake
 * Output: false
 */
package c1_Strings.c5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, pIe -> true
 * pales. pale -> true
 * pale. bale -> true
 * pale. bake -> false
 */
public class OneAwayStarter {
	public static boolean oneEdit(String a, String b) {

		return false;
	}

	// tests
	@Test
	public void emptyStrings() {
		final boolean expected = true;
		final boolean actual = OneAwayStarter.oneEdit("", "");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void zeroEdits() {
		final boolean expected = true;
		final boolean actual = OneAwayStarter.oneEdit("hey", "hey");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void oneRemoval() {
		final boolean expected = true;
		final boolean actual = OneAwayStarter.oneEdit("hey", "heyy");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void oneInsertion() {
		final boolean expected = true;
		final boolean actual = OneAwayStarter.oneEdit("hey", "hy");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void oneEdit() {
		final boolean expected = true;
		final boolean actual = OneAwayStarter.oneEdit("hey", "bey");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void notOneEditAway() {
		final boolean expected = false;
		final boolean actual = OneAwayStarter.oneEdit("bey", "hhy");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void notONeEditAway2() {
		final boolean expected = false;
		final boolean actual = OneAwayStarter.oneEdit("hey", "heyyy");
		Assert.assertEquals(actual, expected);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(OneAwayStarter.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
