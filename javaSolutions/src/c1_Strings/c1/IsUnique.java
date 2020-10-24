package c1_Strings.c1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */
public class IsUnique {

	public static boolean isUnique(String string) {
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		for (Character c : string.toCharArray()) {
			if (map.put(Integer.valueOf(c), c) != null) {
				return false;
			}
		}

		return true;
	}

	@Test
	public void emptyStringTest() {
		boolean expected = true;
		boolean actual = isUnique("");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void oneCharacterStringTest() {
		boolean expected = true;
		boolean actual = isUnique("a");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void AllUniqueStringTest() {
		boolean expected = true;
		boolean actual = isUnique("AbCd");
		Assert.assertEquals(expected, actual);
	}


	@Test
	public void notAllUnique() {
		boolean expected = false;
		boolean actual = isUnique("AbCdd");
		Assert.assertEquals(expected, actual);
	}


	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(IsUnique.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
