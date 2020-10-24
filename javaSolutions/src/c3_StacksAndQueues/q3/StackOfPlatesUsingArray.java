package c3_StacksAndQueues.q3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
 * (that is, pop ( ) should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
 */
public class StackOfPlatesUsingArray {

    private static class SetOfStacks {
        public static final int MAX_CAPACITY = 3;
        public ArrayList<Integer> setOfStacks = new ArrayList();

        public void push(int item) {
            setOfStacks.add(item);
        }

        public int pop() {
            setOfStacks.remove(setOfStacks.size() - 1);
            return 0;
        }

        public int popAtIndex(int i) {
            if (i < 0 || i >= setOfStacks.size()) {
                throw new IndexOutOfBoundsException();
            }
            return setOfStacks.remove(i);
        }

        public int getNumberOfStacks() {
            int round = setOfStacks.size() % 3 == 0 ? 0 : 1;
            return setOfStacks.size() / 3 + round;
        }

        public int size() {
            return setOfStacks.size();
        }
    }


    // tests
    // tests
    @Test(expected = Exception.class)
    public void popEmptyStack() {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.pop();
    }

    @Test
    public void createNewStackAfterCapacity() {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(3);
        setOfStacks.push(6);
        setOfStacks.push(-1);
        setOfStacks.push(3);
        setOfStacks.push(9);
        Assert.assertEquals(5, setOfStacks.size());
        Assert.assertEquals(2, setOfStacks.getNumberOfStacks());
    }


    @Test
    public void removeNewStackAfterPops() {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(3);
        setOfStacks.push(6);
        setOfStacks.push(-1);
        setOfStacks.push(3);
        setOfStacks.push(9);
        Assert.assertEquals(5, setOfStacks.size());
        Assert.assertEquals(2, setOfStacks.getNumberOfStacks());

        setOfStacks.pop();
        setOfStacks.pop();
        Assert.assertEquals(3, setOfStacks.size());
        Assert.assertEquals(1, setOfStacks.getNumberOfStacks());
    }

    @Test(expected = Exception.class)
    public void popAtIndexInvalidIndex() {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(3);
        setOfStacks.push(6);
        setOfStacks.popAtIndex(2);
    }

    @Test
    public void popAtIndex() {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(3);
        setOfStacks.push(6);
        setOfStacks.push(4);
        setOfStacks.push(-4);

        Assert.assertEquals(4, setOfStacks.size());
        Assert.assertEquals(2, setOfStacks.getNumberOfStacks());

        int expectedPopValue = setOfStacks.popAtIndex(1);
        Assert.assertEquals(6, expectedPopValue);
        Assert.assertEquals(3, setOfStacks.size());
        Assert.assertEquals(1, setOfStacks.getNumberOfStacks());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(StackOfPlatesUsingArray.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}