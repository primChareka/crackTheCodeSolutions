import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class TemplateEmpty {

    //Method
//    public static() {
//        // reverse input array of characters in place
//    }

    public static String makeCamelCase(String s){
        StringBuilder builder = new StringBuilder();

        String[] array = s.substring(0,s.length()-1).split(" ");

        for(String word: array){
            String formatted = word.toLowerCase();
            builder.append(Character.toUpperCase(formatted.charAt(0))).append(formatted.substring(1));
        }

        char lastChar = s.charAt(s.length()-1);
        if(lastChar=='!'||lastChar=='.'||lastChar=='?'){
            builder.append(lastChar);
        }else{
            builder.append(lastChar>96||lastChar<123?lastChar:lastChar+32);
        }

        return builder.toString();
    }

    public static void main(String args[]){
        makeCamelCase("HELLO my NAme is Prim!");
        makeCamelCase("HELLO my NAme is Prim");
    }


    // tests
    @Test(expected = Exception.class)
    public void emptyStringTest() {
        //actual =
        //expected =
        //assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        //actual =
        //expected =
        //assertArrayEquals(expected, actual);
    }
//
//        public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(TemplateEmpty.class);
//        for (Failure failure : result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        if (result.wasSuccessful()) {
//            System.out.println("All tests passed.");
//        }

}