package c4_TreesAndGraphs.inorder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeStarter {

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static List<Integer> InOrder(BinaryTreeNode treeRoot) {
        Stack<BinaryTreeNode> stack = new Stack();
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> handled= new HashSet<>();
        if (treeRoot == null)
            return result;

        stack.push(treeRoot);
        BinaryTreeNode current;
        while(!stack.isEmpty()){
            current = stack.pop();
            if(handled.contains(current.value)){
                result.add(current.value);
            }else {
                if(current.right!=null)
                    stack.push(current.right);
                stack.push(current);
                if(current.left!=null)
                    stack.push(current.left);
                handled.add(current.value);
            }

        }


        return result;
    }


    // tests

    @Test
    public void InorderTest() {
        final BinaryTreeNode root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.insertLeft(3);
        final BinaryTreeNode b = root.insertRight(8);
        a.insertLeft(1);
        a.insertRight(4);
        b.insertLeft(6);
        final BinaryTreeNode c = b.insertRight(9);
        c.insertRight(12);
        ArrayList<Integer> expected = new ArrayList();
        expected.add(1);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(8);
        expected.add(9);
        expected.add(12);

        List<Integer> result = InOrder(root);
        Assert.assertArrayEquals(expected.toArray(),result.toArray());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BinaryTreeNode.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}