package c5_bitMan.q1_Insertion;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class BitNumInsertion {

    public static int fitBetweenTwoBits(int base, int numToInsertAdd, int start, int end) {
        //mask base with num that has zeros from i to j 1 else where
        //mask numTo insert to have all 1's outside of range
        //or two numbers together  //numtoadd= 00000000000000000000000000010101
        int allOnes = ~0;              //base=   00000000000000000000010000000000
        int left = allOnes << (end + 1);       //11111111111111111111111110000000 = -128
        int right = (1 << start) - 1;          //00000000000000000000000000000011 = 3
        int mask = left | right;               //11111111111111111111111110000011 = -125
        int temp = base & mask;                //00000000000000000000010000000000 = 1024
        int temp2 = numToInsertAdd << start;   //00000000000000000000000001010100

        return temp | temp2;
    }

    @Test
    public void test() {
        int x = 1024; //10000000000
        int y = 21; //10101
        int start = 2;
        int end = 6;
        int result = fitBetweenTwoBits(x, y, start, end);
        int expected = 1108; //10001010100
        Assert.assertEquals(expected,result);

    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BitNumInsertion.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
