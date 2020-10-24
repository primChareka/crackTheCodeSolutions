package c8_recursionAndDynamicProgramming.q1_tripleStep;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TripleStep {

    public static int numWaysUpStairs(int numStairs) {
        int[] waysAtStep = new int[numStairs+1];
        int w = numWaysForNthStep(numStairs, 3, waysAtStep);
        int x = numWaysForNthStep(numStairs, 2, waysAtStep);
        int y = numWaysForNthStep(numStairs, 1, waysAtStep);
        return w+x+y;


    }

    public static int numWaysForNthStep(int stepsLeft, int stepSize, int[] waysAtStep) {

        if (stepsLeft < stepSize)
            return 0;

        if (stepsLeft == stepSize) {
            return 1;
        }
        int sum;
        if (waysAtStep[stepsLeft-stepSize] == 0) {
            int w = numWaysForNthStep(stepsLeft - stepSize, 3, waysAtStep);
            int x = numWaysForNthStep(stepsLeft - stepSize, 2, waysAtStep);
            int y = numWaysForNthStep(stepsLeft - stepSize, 1, waysAtStep);
            sum = w+x+y;
            waysAtStep[stepsLeft-stepSize] = sum;
        } else {
            return waysAtStep[stepsLeft-stepSize];
        }

        return sum;
    }


    public static int numWaysUpStairsIterative(int numStairs) {
        int[] waysAtStep = new int[numStairs+1];

        waysAtStep[0]=1;

        for(int i=0;i<numStairs;i++){
            if(i+1<numStairs){
                waysAtStep[i+1]+=waysAtStep[i];
            }

            if(i+2<numStairs){
                waysAtStep[i+3]+=waysAtStep[i];
            }

            if(i+3<numStairs){
                waysAtStep[i+3]+=waysAtStep[i];
            }
        }
        return waysAtStep[numStairs];
    }

    @Test
    public void testRecursive() {
        int result = numWaysUpStairs(4);
        int expected = 7;
        Assert.assertEquals(expected,result);
    }

    @Test
    public void testIterative() {
        int result = numWaysUpStairs(4);
        int expected = 7;
        Assert.assertEquals(expected,result);
    }



    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TripleStep.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}
