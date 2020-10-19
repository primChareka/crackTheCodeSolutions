package c4_TreesAndGraphs.c3_ListofDepths;

import c4_TreesAndGraphs.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

public class ListOfDepths {
    public static HashMap<Integer, LinkedList<BinaryTreeNode>> listOfNodesPerLevel(BinaryTreeNode root) {
        //1) how many node are at a level
        //2) for all nodes on that level add them to a list
        //3) keep track of what level we are on

        HashMap<Integer, LinkedList<BinaryTreeNode>> nodesPerLevel = new HashMap<>();
        if (root == null) {
            return nodesPerLevel;
        }

        Queue<BinaryTreeNode> children = new ArrayDeque<>();
        children.add(root);


        int level = 1;
        int nodesOnThisLevel = 1;
        int numNodesNextLevel = 0;

        BinaryTreeNode current;
        LinkedList<BinaryTreeNode> listOfNodes = new LinkedList();

        while (!children.isEmpty()) {
            current = children.remove();
            listOfNodes.add(current);
            nodesOnThisLevel--;

            if (current.left != null) {
                children.add(current.left);
                numNodesNextLevel++;
            }

            if (current.right != null) {
                children.add(current.right);
                numNodesNextLevel++;
            }

            if (nodesOnThisLevel == 0) {
                nodesOnThisLevel = numNodesNextLevel;
                numNodesNextLevel = 0;

                nodesPerLevel.put(level, listOfNodes);
                listOfNodes = new LinkedList<>();

                level++;
            }
        }
        return nodesPerLevel;
    }


    // tests

    @Test
    public void nullRoot() {
        HashMap<Integer, LinkedList<BinaryTreeNode>> result = listOfNodesPerLevel(null);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void oneNode() {
        BinaryTreeNode root = new BinaryTreeNode(5);

        HashMap<Integer, LinkedList<BinaryTreeNode>> result = listOfNodesPerLevel(root);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void twoNodeTwoLevels() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.insertLeft(3);

        HashMap<Integer, LinkedList<BinaryTreeNode>> result = listOfNodesPerLevel(root);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.get(1).contains(root));
    }

    @Test
    public void unEvenNodesPerLevel() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.insertLeft(3);
        final BinaryTreeNode b = root.insertRight(8);
        final BinaryTreeNode c = b.insertRight(9);
        a.insertRight(4);
        b.insertLeft(6);
        c.insertRight(12);

        HashMap<Integer, LinkedList<BinaryTreeNode>> result = listOfNodesPerLevel(root);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(1, result.get(1).size());
        Assert.assertEquals(2, result.get(2).size());
        Assert.assertEquals(3, result.get(3).size());
        Assert.assertEquals(1, result.get(4).size());
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ListOfDepths.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}
