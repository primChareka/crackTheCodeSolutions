package c4_TreesAndGraphs.in_pre_post_order;

import c4_TreesAndGraphs.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
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

public class PostOrderTraversal {

    public static List<Integer> postOrderRecursive(BinaryTreeNode treeRoot){
        ArrayList<Integer> result = new ArrayList();
        if(treeRoot==null){
            return result;
        }
        if(treeRoot.left!=null)
            result.addAll(postOrderRecursive(treeRoot.left));

        if(treeRoot.right!=null)
            result.addAll(postOrderRecursive(treeRoot.right));

        result.add(treeRoot.value);
        return result;
    }





    public static List<Integer> postOrderIterative(BinaryTreeNode treeRoot){
        Stack<BinaryTreeNode> stack = new Stack<>();
        HashSet<BinaryTreeNode> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList();

        if(treeRoot==null) return result;
        stack.push(treeRoot);

        while(!stack.isEmpty()){
            BinaryTreeNode n = stack.pop();
            if(visited.contains(n)){
                result.add(n.value);
            }else{
                visited.add(n);
                stack.push(n);
                if(n.right!=null)
                    stack.push(n.right);

                if(n.left!=null)
                    stack.push(n.left);
            }
        }
        return result;
    }


    // tests
    BinaryTreeNode root;
    ArrayList<Integer> expected;
    @Before
    public void setup(){
        root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.insertLeft(3);
        final BinaryTreeNode b = root.insertRight(8);
        final BinaryTreeNode c = b.insertRight(9);
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
    public void postOrderRecursiveTest() {
        List<Integer> result = postOrderRecursive(root);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void postOrderIterativeTest() {
        List<Integer> result = postOrderIterative(root);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PostOrderTraversal.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}