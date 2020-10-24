package c1_Strings.c2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class CheckPermutation {


    public static boolean isPermutation(String s1, String s2) {
        if(s1.isEmpty()&&s2.isEmpty()){
            return true;
        }else if(s1.length()!=s2.length()){
            return false;
        }else{
            HashMap<Character,Integer > lettersInString1 = new HashMap<>();
            int temp = 0;
            for(char c: s1.toCharArray()){
                if(lettersInString1.containsKey(c)) {
                    temp = lettersInString1.get(c);
                    temp++;
                    lettersInString1.put(c, temp);
                }else{
                    lettersInString1.put(c,1);
                }
            }

            for(char c: s2.toCharArray()){
                if(lettersInString1.containsKey(c)){
                    temp = lettersInString1.get(c);
                    if(temp==1){
                        lettersInString1.remove(c);
                    }else{
                        temp--;
                        lettersInString1.put(c,temp);
                    }
                }else{
                    return false;
                }
            }

            if(lettersInString1.isEmpty()) {
                return true;
            }
            return false;
        }
    }


    // tests
    @Test
    public void emptyStringTest() {
        boolean expected = true;
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
        Result result = JUnitCore.runClasses(CheckPermutation.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}