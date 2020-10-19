package c5_bitMan.q5_flipBitToWin;

import c5_bitMan.q1_Insertion.BitNumInsertion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class FlipBitToWin {

    public static int flipBitToWIn(int num){
        if(num==-1)
            return 32;

        int group1 = 0;
        int group2 = 0;
        int max = 0;
        while(num!=0){
            if((num&1)==1){
                group2++;
            }else{
                max = Math.max(group1+group2 +1, max);
                group1=group2;
                group2=0;
            }

            num = num >>> 1;
        }

        return  Math.max(group1+group2 +1, max);

    }

    @Test
    public void flipBitAllZeros(){
        int num = 0;
        int result = flipBitToWIn(num);
        Assert.assertEquals(1,result);
    }

    @Test
    public void flipBitAllOnes(){
        int num = -1;
        int result = flipBitToWIn(num);
        Assert.assertEquals(32,result);
    }

    @Test
    public void flipBitNumIsOne(){
        int num = 1;
        int result = flipBitToWIn(num);
        Assert.assertEquals(2,result);
    }

    @Test
    public void flipBitNumIsTwo(){
        int num = 2;
        int result = flipBitToWIn(num);
        Assert.assertEquals(2,result);
    }

    @Test public void flipBitNumIsNegative(){
        int num = -8;
        int result = flipBitToWIn(num);
        Assert.assertEquals(30,result);
    }

    @Test
    public void flipBitRandomSequence(){
        int num = 1775;
        int result = flipBitToWIn(num);
        Assert.assertEquals(8,result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FlipBitToWin.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
