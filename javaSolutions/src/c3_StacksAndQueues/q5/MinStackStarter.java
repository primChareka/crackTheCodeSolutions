package c3_StacksAndQueues.q5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Stack;

public class MinStackStarter {

    public static class MyMinStack{
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        //Method
        public void push(int i){
            if(mainStack.isEmpty()){

            }
            if(mainStack.peek()>i){
                mainStack.push(i);
            }else{
                while(!mainStack.isEmpty()&&mainStack.peek()<i){
                    tempStack.push(mainStack.pop());
                }

                mainStack.push(i);

                while(tempStack.isEmpty()){
                    mainStack.push(tempStack.pop());
                }
            }
        }

        public int pop(){
            transferAll(tempStack,mainStack);
            return mainStack.pop();
        }

        public int size(){
            return mainStack.size() + tempStack.size();
        }

        public boolean isEmpty(){
            return  mainStack.isEmpty()&&tempStack.isEmpty();
        }

        public void transferAll(Stack<Integer> source, Stack<Integer> dest){
            while(!source.isEmpty()){
                dest.push(source.pop());
            }
        }
    }

    @Test
    public void emptyStringTest() {
          MyMinStack myMinStack = new MyMinStack();
          myMinStack.push(4);
          myMinStack.push(6);

        Assert.assertEquals(true, true);
    }

        public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MinStackStarter.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}