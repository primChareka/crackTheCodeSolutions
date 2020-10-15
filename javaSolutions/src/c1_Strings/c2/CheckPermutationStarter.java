package c1_Strings.c2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class CheckPermutationStarter {


    public static boolean isPermutation(String s1, String s2) {
        return true;
    }


    // tests
    @Test
    public void emptyStringTest() {
        boolean expected = false;
        boolean actual = isPermutation("", "");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void unevenStringLength() {
        boolean expected = false;
        boolean actual = isPermutation("bat", "tabs");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void notPermutaion() {
        boolean expected = false;
        boolean actual = isPermutation("bat", "tub");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isPermutaion() {
        boolean expected = true;
        boolean actual = isPermutation("bat", "tab");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isPermutaionRepeatedLetters() {
        boolean expected = true;
        boolean actual = isPermutation("aabbc", "bbcaa");
        Assert.assertEquals(expected, actual);
    }

        public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CheckPermutationStarter.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}