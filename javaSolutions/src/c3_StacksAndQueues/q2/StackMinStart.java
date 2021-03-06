package c3_StacksAndQueues.q2;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class StackMinStart {

    public static class MinStack {
        public int pop() {

            return 0;
        }

        public void push(int i) {

        }

        public int min() {
            return 0;
        }
    }


    // tests
    @Test(expected = Exception.class)
    public void popEmptyStack() {
        MinStack minStack = new MinStack();
        minStack.pop();
    }

    @Test
    public void allNewMins() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        assertEquals(5, minStack.min());
        minStack.push(4);
        assertEquals(4, minStack.min());
        minStack.push(3);
        assertEquals(3, minStack.min());
        minStack.push(2);
        assertEquals(2, minStack.min());
        minStack.push(1);
        assertEquals(1, minStack.min());
    }

    @Test
    public void oneNewMin() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        assertEquals(5, minStack.min());
        minStack.push(7);
        assertEquals(5, minStack.min());
        minStack.push(3);
        assertEquals(3, minStack.min());
        minStack.push(6);
        assertEquals(3, minStack.min());
    }

    @Test
    public void multiplePops() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        assertEquals(5, minStack.min());
        minStack.push(7);
        minStack.push(3);
        assertEquals(3, minStack.min());
        minStack.pop();
        assertEquals(5, minStack.min());
        minStack.pop();
        minStack.pop();
    }

    @Test
    public void checkMinOnEmpty() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        assertEquals(5, minStack.min());
        minStack.push(7);
        minStack.push(3);
        assertEquals(3, minStack.min());
        minStack.pop();
        assertEquals(5, minStack.min());
        minStack.pop();
        minStack.pop();
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(StackMinStart.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}