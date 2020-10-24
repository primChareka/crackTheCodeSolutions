package c16_moderate.q5_letttersAndNumbers;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Arrays;


public class NumbersAndLetters {


    public static char[]  longestSubArrayOfEqualLetAndNum(char[] array) {
        //Turn into simplified array
        //Use a 1 if it is a letter, use a zero if it is a number. Assume array never has bad input that is not a letters or number
        char[] simpleArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            simpleArray[i] = Character.isLetter(array[i]) ? '1' : '0';
        }

        //|0,1,2,3,4,5|
        //[1,2,3,4,5,6]
        int startIndex=0;
        int endIndex;
        for (endIndex = array.length; endIndex > 0; endIndex--) {//i.e 6-1
            for (startIndex = 0; startIndex < endIndex; startIndex++) {
                if (count('1', startIndex, endIndex, array) == count('0', startIndex, endIndex, array))
                    break;
            }

            if (startIndex + 1 != endIndex) {
                System.out.println("second break");
                break;
            }
        }
        System.out.println("StartIndex: " + startIndex + " EndIndex: "+ endIndex);
        return Arrays.copyOfRange(array,startIndex,endIndex);
    }
    public static int count(char val, int start, int end, char[] array) {
        int num = 0;
        for (int i = start; i<end;i++) {
            if (array[i] == val)
                num++;
        }
        return num;
    }

    @Test
    public void nameFrequencies() {

        char [] input = {'A', '7', 'A', 'A', 'A', '9', '0', '2', 'A', '7', 'A', 'A', '0', '1', 'A', 'A', 'A', 'A', 'A','A'};
        char[] result = longestSubArrayOfEqualLetAndNum(input);
        System.out.print("[");
        for(char c: result){
            System.out.print(c+",");
        }
        System.out.print("]");
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(NumbersAndLetters.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
