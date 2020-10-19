package c4_TreesAndGraphs.in_pre_post_order;

import c4_TreesAndGraphs.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public static List<Integer> preOrderRecursive(BinaryTreeNode treeRoot){
        ArrayList<Integer> result = new ArrayList();
        if(treeRoot==null){
            return result;
        }
        result.add(treeRoot.value);
        if(treeRoot.left!=null)
            result.addAll(preOrderRecursive(treeRoot.left));

        if(treeRoot.right!=null)
            result.addAll(preOrderRecursive(treeRoot.right));

        return result;
    }

    public static List<Integer> preOrderIterative(BinaryTreeNode treeRoot){
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList();

        if(treeRoot==null) return result;
        stack.push(treeRoot);

        while(!stack.isEmpty()){
            BinaryTreeNode n = stack.pop();
            result.add(n.value);

            if(n.right!=null){
                stack.push(n.right);
            }
            if(n.left!=null){
                stack.push(n.left);
            }
        }
        return result;
    }




    // tests
    c4_TreesAndGraphs.BinaryTreeNode root;
    ArrayList<Integer> expected;
    @Before
    public void setup(){
        root = new c4_TreesAndGraphs.BinaryTreeNode(5);
        final c4_TreesAndGraphs.BinaryTreeNode a = root.insertLeft(3);
        final c4_TreesAndGraphs.BinaryTreeNode b = root.insertRight(8);
        final c4_TreesAndGraphs.BinaryTreeNode c = b.insertRight(9);
        a.insertLeft(1);
        a.insertRight(4);
        b.insertLeft(6);
        c.insertRight(12);

        expected = new ArrayList();
        expected.add(1);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(8);
        expected.add(9);
        expected.add(12);
    }

    @Test
    public void preOrderRecursiveTest() {
        ArrayList<Integer> expected = new ArrayList();
        expected.add(5);
        expected.add(3);
        expected.add(1);
        expected.add(4);
        expected.add(8);
        expected.add(6);
        expected.add(9);
        expected.add(12);
        List<Integer> result = preOrderRecursive(root);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void preOrderIterativeTest() {
        List<Integer> result = preOrderIterative(root);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }



    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PreOrderTraversal.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}