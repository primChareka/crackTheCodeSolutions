package c3_StacksAndQueues.q3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Stack;
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
public class StackOfPlatesUsingStacks {

    private static class SetOfStacks{
        public static final int MAX_CAPACITY = 3;
        Stack<Stack> setOfOlderStacks = new Stack<>();
        Stack<Integer> topStack = null;

        public void push(int item){
            if(topStack==null){
                topStack = new Stack();
            }

            if(topStack.size()==MAX_CAPACITY){
                setOfOlderStacks.push(topStack);
                topStack=new Stack();
            }

            topStack.push(item);
        }

        public int pop(){
            if(topStack==null){
                throw new IllegalArgumentException();
            }

            int val = topStack.pop();

            if(topStack.size()==0){
                topStack = !setOfOlderStacks.isEmpty()? setOfOlderStacks.pop(): null;
            }
            return val;
        }

        public int popAtIndex(int i){
            if(i<0 || i > size()-1){
                throw new IllegalArgumentException();
            }

            Stack<Integer> temp = new Stack();
            for(int k = size(); k>i+1; k--){
                temp.push(pop());
            }

            int val = pop();

            while(!temp.isEmpty()){
                push(temp.pop());
            }
            return val;
        }

        public int getNumberOfStacks(){
            return setOfOlderStacks.size()+1;
        }

        public int size(){
            return setOfOlderStacks.size()*MAX_CAPACITY + topStack.size();
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
        Assert.assertEquals(1,setOfStacks.getNumberOfStacks());
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
        Result result = JUnitCore.runClasses(StackOfPlatesUsingStacks.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}