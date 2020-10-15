package c4_TreesAndGraphs.in_pre_post_order;

import c4_TreesAndGraphs.BinaryTreeNode;
import c4_TreesAndGraphs.BinaryTreeStarter;
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

public class inOrderTraversal {

    public static List<Integer> inOrderRecursive(BinaryTreeNode treeRoot){
        ArrayList<Integer> result = new ArrayList();
        if(treeRoot==null){
            return result;
        }

        if(treeRoot.left!=null){
            result.addAll(inOrderRecursive(treeRoot.left));
        }
        result.add(treeRoot.value);
        if(treeRoot.right!=null){
            result.addAll(inOrderRecursive(treeRoot.right));
        }


        return result;
    }

    public static List<Integer> inOrderIterative(BinaryTreeNode treeRoot) {
        ArrayList<Integer> result = new ArrayList();
        Stack<BinaryTreeNode> stack = new Stack();
        HashSet<BinaryTreeNode> visited = new HashSet<>();
        if (treeRoot == null) return null;
        stack.push(treeRoot);

        while (!stack.isEmpty()) {
            BinaryTreeNode n = stack.pop();
            if (visited.contains(n)) {
                result.add(n.value);
            } else {
                visited.add(n);
                if (n.right != null)
                    stack.push(n.right);

                stack.push(n);

                if (n.left != null)
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
    public void InorderRecursiveTest() {
        List<Integer> result = inOrderRecursive(root);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void InorderIterativeTest() {
        List<Integer> result = inOrderIterative(root);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(inOrderTraversal.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}