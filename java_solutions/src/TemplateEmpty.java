import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertArrayEquals;

public class TemplateEmpty {

    //Method
//    public static() {
//        // reverse input array of characters in place
//    }


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

        public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TemplateEmpty.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}