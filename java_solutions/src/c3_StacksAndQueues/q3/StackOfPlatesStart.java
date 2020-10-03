package c3_StacksAndQueues.q3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

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
public class StackOfPlatesStart {

    private static class SetOfStacks{
        public static final int MAX_CAPACITY = 3;

        public void push(int item){

        }

        public int pop(){

            return 0;
        }

        public int popAtIndex(int i){

            return 0;
        }

        public int getNumberOfStacks(){
            return 0;
        }

        public int size(){
            return 0;
        }
    }


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
        Assert.assertEquals(5,setOfStacks.size());
        //2
        Assert.assertEquals(setOfStacks.size()/SetOfStacks.MAX_CAPACITY+1,setOfStacks.getNumberOfStacks());
    }


    @Test
    public void removeNewStackAfterPops() {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(3);
        setOfStacks.push(6);
        setOfStacks.push(-1);
        setOfStacks.push(3);
        setOfStacks.push(9);
        Assert.assertEquals(5,setOfStacks.size());
        Assert.assertEquals(2,setOfStacks.getNumberOfStacks());

        setOfStacks.pop();
        setOfStacks.pop();
        Assert.assertEquals(3,setOfStacks.size());
        Assert.assertEquals(11,setOfStacks.getNumberOfStacks());
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

        Assert.assertEquals(4,setOfStacks.size());
        Assert.assertEquals(2,setOfStacks.getNumberOfStacks());

        int expectedPopValue = setOfStacks.popAtIndex(1);
        Assert.assertEquals(6, expectedPopValue);
        Assert.assertEquals(3,setOfStacks.size());
        Assert.assertEquals(1,setOfStacks.getNumberOfStacks());
    }

        public static void main(String[] args) {
        Result result = JUnitCore.runClasses(StackOfPlatesStart.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}