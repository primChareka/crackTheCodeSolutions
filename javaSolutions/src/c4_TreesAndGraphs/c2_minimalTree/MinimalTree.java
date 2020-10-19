package c4_TreesAndGraphs.c2_minimalTree;

import c4_TreesAndGraphs.BinaryTreeNode;
import c4_TreesAndGraphs.in_pre_post_order.InOrderTraversal;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class MinimalTree {

    public static BinaryTreeNode minimalTree(int[] vals) {
        if (vals.length == 0)
            return null;


        if (vals.length == 1) {
            return new BinaryTreeNode(vals[0]);
        }

        if (vals.length == 2) {
            BinaryTreeNode root = new BinaryTreeNode(vals[1]);
            BinaryTreeNode leftChild = new BinaryTreeNode(vals[0]);
            root.left = leftChild;
            return root;
        }

        int start = 0;
        int end = vals.length - 1;
        int mid = (end - start) / 2; //int division will round down

        BinaryTreeNode root = new BinaryTreeNode(vals[mid]);
        addChild(start, mid - 1, vals, root);
        addChild(mid + 1, end, vals, root);

        return root;
    }

    public static void addChild(int start, int end, int[] vals, BinaryTreeNode parent) {
        BinaryTreeNode current;
        if (start >= end) {
            //one element in array
            current = new BinaryTreeNode(vals[start]);
        } else if (start + 1 == end) {
            //two elements in array
            //set higher value to parents child, lower value to currents left child
            current = new BinaryTreeNode(vals[end]);
            BinaryTreeNode leftChild = new BinaryTreeNode(vals[start]);
            current.left = leftChild;
        } else {
            int mid = (end - start) / 2;
            mid = start + mid;
            current = new BinaryTreeNode(vals[mid]);
            addChild(start, mid - 1, vals, current);
            addChild(mid + 1, end, vals, current);
        }

        if (current.value <= parent.value) {
            parent.left = current;
        } else {
            parent.right = current;
        }
    }

    public static BinaryTreeNode minimalTreeIterative(int[] vals) {
        if (vals.length == 0)
            return null;

        if (vals.length == 1) {
            return new BinaryTreeNode(vals[0]);
        }

        if (vals.length == 2) {
            BinaryTreeNode root = new BinaryTreeNode(vals[1]);
            BinaryTreeNode leftChild = new BinaryTreeNode(vals[0]);
            root.left = leftChild;
            return root;
        }

        Queue<BinaryTreeNode> parents = new ArrayDeque<>();
        BinaryTreeNode currentParent;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        int jump;
        int start = 0;
        int end = vals.length - 1;
        int mid = (end - start) / 2; //int division will round down
        BinaryTreeNode root = new BinaryTreeNode(vals[mid]);
        parents.add(root);

        for (int log2 = 1; log2 < vals.length; log2 *= 2) {//do log2 iterations
            jump = vals.length / (2 * log2);//jump double each time there for jump halves each time
            start=0;
            end=start+2*jump-1-1;//-1 to account for node we looked at
            mid = (end - start) / 2;
            for (int x = 0; x < log2; x++) {
                //TODO how to solve if there is a trailing child
                currentParent = parents.peek();
                int leftMid = start + (mid - start) / 2;

                int rightMid = mid + (end - mid+1) / 2;
                leftChild = new BinaryTreeNode(vals[leftMid]);
                rightChild = new BinaryTreeNode(vals[rightMid]);

                currentParent.left=leftChild;
                currentParent.right=rightChild;
                if(!(start+1>=mid&&start==leftMid))//no nodes between start and current && no nodes to left of child
                    parents.add(leftChild);
                if(!(mid+1>=end&&end>=rightMid))//no nodes between current and end of list && no nodes to right of child
                    parents.add(rightChild);
                start=end+2;//1 spot to move to the parent element, another spot to move to the other side of it
                end+=jump*2+1;//1 spot to move past the element we were just at
                mid=start + (end - start) / 2;;
            }
        }

        //|  1X | 7X  | 9 X | 12X  | 15  | 25X  | 30  | 40  |
        //|  0  | 1   | 2   |  3   |  4  |  5  |  6  |  7  |

        return root;
    }

    @Test
    public void test() {
//        int[] sortedValues = {1, 3, 5, 8, 9, 12, 16, 19, 20, 56, 77, 89};
        int[] sortedValues = {1,7,9,12,15,25,30,40};
        BinaryTreeNode result = minimalTreeIterative(sortedValues);
        List<Integer> values = InOrderTraversal.inOrderIterative(result);
        BinaryTreeNode.printBreadthFirst(result);
        System.out.println(values);
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
