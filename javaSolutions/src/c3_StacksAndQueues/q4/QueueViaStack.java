package c3_StacksAndQueues.q4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueViaStack {

    private static class MyQueue {
        private Stack<Integer> pushStack = new Stack<>();
        private Stack<Integer> popStack = new Stack<>();

        public void add(Integer i) {
            pushStack.push(i);
        }

        /**
         * Retrieves and removes the head of this queue.  Throws an exception if
         * this queue is empty.
         *
         * @return the head of this queue
         * @throws NoSuchElementException if this queue is empty
         */
        public Integer remove() {
            //Peek makes sure pop stack has current value at the top, throws error if both stacks are empty
            peek();
            return popStack.pop();
        }

        /**
         * Retrieves, but does not remove, the head of this queue.  Throws an exception
         * if this queue is empty.
         *
         * @return the head of this queue
         * @throws NoSuchElementException if this queue is empty
         */
        public Integer peek() {
            int temp = 0;
            if(popStack.isEmpty()&&pushStack.isEmpty()){
                throw new NoSuchElementException();
            }else if(!popStack.isEmpty()){
                //Pop stack has items, so we don't need to worry about push stack
                temp = popStack.peek();
            }else{
                //Pop stack is empty but pushStack is not
                int tmp;
                while(!pushStack.isEmpty()){
                    tmp = pushStack.pop();
                    popStack.push(tmp);
                }
                temp = popStack.peek();
            }
            return temp;
        }

        public int size() {
            return pushStack.size() + popStack.size();
        }

        public boolean isEmpty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }


    // tests
    @Test
    public void isEmptyWorks() {
        MyQueue myQueue = new MyQueue();
        boolean expected = true;
        boolean actual = myQueue.isEmpty();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void removeOnEmpty() {
        MyQueue myQueue = new MyQueue();
        myQueue.remove();
    }

    @Test(expected = Exception.class)
    public void peekOnEmptyQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.peek();
    }

    @Test
    public void insertWorks() {
        MyQueue myQueue = new MyQueue();
        myQueue.add(0);
        myQueue.add(1);
        int expected = 2;
        int actual = myQueue.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void peekWorks() {
        MyQueue myQueue = new MyQueue();
        myQueue.add(0);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(4);
        myQueue.add(9);
        myQueue.add(3);
        int expectedPeekVal = 0;
        int actualPeekVal = myQueue.peek();

        int expectedSize = 6;
        int actualSize = myQueue.size();

        Assert.assertEquals(expectedPeekVal, actualPeekVal);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeWorks() {
        MyQueue myQueue = new MyQueue();
        myQueue.add(0);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(4);
        myQueue.add(9);
        myQueue.add(3);

        int expectedRemoveVal = 0;
        int actualRemoveVal = myQueue.remove();

        int expectedSize = 5;
        int actualSize = myQueue.size();

        Assert.assertEquals(expectedRemoveVal, actualRemoveVal);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void MixAndMatch() {
        MyQueue myQueue = new MyQueue();
        myQueue.add(0);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(4);

        int expectedRemoveVal = 0;
        int expectedSize = 3;
        int actualRemoveVal = myQueue.remove();
        int actualSize = myQueue.size();
        Assert.assertEquals(expectedRemoveVal, actualRemoveVal);
        Assert.assertEquals(expectedSize, actualSize);

        myQueue.add(9);
        myQueue.add(3);
        expectedSize = 5;
        actualSize = myQueue.size();
        Assert.assertEquals(expectedSize, actualSize);

        actualRemoveVal = myQueue.remove();
        actualRemoveVal = myQueue.remove();

        expectedRemoveVal = 2;
        expectedSize = 3;
        actualSize = myQueue.size();

        Assert.assertEquals(expectedRemoveVal, actualRemoveVal);
        Assert.assertEquals(expectedSize, actualSize);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(QueueViaStack.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}