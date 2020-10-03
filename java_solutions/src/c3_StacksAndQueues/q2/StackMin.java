package c3_StacksAndQueues.q2;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class StackMin {

    public static class MinStack {
        private int min = 0;
        private Stack<Integer> allItemsStack = new Stack<>();
        private Stack<Integer> lastSeenMinStack = new Stack<>();

        public int pop() {
            int top = allItemsStack.pop();
            if(top==min){
                lastSeenMinStack.pop();
                if(!lastSeenMinStack.isEmpty())
                    min=lastSeenMinStack.peek();
            }
            return top;
        }

        public void push(int item) {
            if(allItemsStack.isEmpty()){
                min = item;
            }

            if(item<=min){
                min=item;
                lastSeenMinStack.push(item);
            }

            allItemsStack.push(item);
        }

        public int min() {
            if(lastSeenMinStack.isEmpty()){
                throw new IllegalArgumentException();
            }

            return lastSeenMinStack.peek();
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
        Result result = JUnitCore.runClasses(StackMin.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}