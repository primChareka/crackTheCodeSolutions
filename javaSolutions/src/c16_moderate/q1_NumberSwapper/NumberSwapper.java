package c16_moderate.q1_NumberSwapper;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class NumberSwapper {
    public static int[] numberSwapper(int x, int y) {
        x -= y;
        y += x;
        x = y - x;

        int[] nums = {x, y};
        return nums;
    }


    @Test
    public void poitiveNumbers() {
        int x = 7;
        int y = 2;
        int[] result = numberSwapper(x, y);
        Assert.assertEquals(y, result[0]);
        Assert.assertEquals(x, result[1]);
    }

    @Test
    public void mixedNumbers() {
        int x = -6;
        int y = 2;
        int[] result = numberSwapper(x, y);
        Assert.assertEquals(y, result[0]);
        Assert.assertEquals(x, result[1]);
    }

    @Test
    public void negativeNumbers() {
        int x = -11;
        int y = 3;
        int[] result = numberSwapper(x, y);
        Assert.assertEquals(y, result[0]);
        Assert.assertEquals(x, result[1]);
    }

    @Test
    public void OneZeroNumber() {
        int x = 0;
        int y = 2;
        int[] result = numberSwapper(x, y);
        Assert.assertEquals(y, result[0]);
        Assert.assertEquals(x, result[1]);
    }

    @Test
    public void TwoZeroNumber() {
        int x = 0;
        int y = 2;
        int[] result = numberSwapper(x, y);
        Assert.assertEquals(y, result[0]);
        Assert.assertEquals(x, result[1]);
    }

    @Test
    public void OneOneNumber() {
        int x = 1;
        int y = 5;
        int[] result = numberSwapper(x, y);
        Assert.assertEquals(y, result[0]);
        Assert.assertEquals(x, result[1]);
    }

    @Test
    public void TwoOnesNumber() {
        int x = 1;
        int y = 1;
        int[] result = numberSwapper(x, y);
        Assert.assertEquals(y, result[0]);
        Assert.assertEquals(x, result[1]);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(NumberSwapper.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
