package c4_TreesAndGraphs.minMaxHeap;

import c4_TreesAndGraphs.BinaryTreeNode;
import c4_TreesAndGraphs.BinaryTreeNodeWithParent;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinHeapImplementation {
    public static class MinHeap {
        private static BinaryTreeNodeWithParent root;

        private static BinaryTreeNodeWithParent getNextParent() {
            Deque<BinaryTreeNodeWithParent> q = new ArrayDeque<>();
            q.add(root);
            int nodesAtLevel = 1;
            int nextLevel = 0;

            while (!q.isEmpty()) {
                if (nodesAtLevel == 0) {
                    nodesAtLevel = nextLevel;
                    nextLevel = 0;
                }

                BinaryTreeNodeWithParent current = q.remove();
                nodesAtLevel--;

                if (current.left == null || current.right == null) {
                    return current;
                }
                if (current.left != null) {
                    q.add(current.left);
                    nextLevel++;
                }

                if (current.right != null) {
                    q.add(current.right);
                    nextLevel++;
                }
            }
            return null;
        }

        private static BinaryTreeNodeWithParent getLastNode() {
            Deque<BinaryTreeNodeWithParent> q = new ArrayDeque<>();
            if (root == null) return null;

            q.add(root);
            BinaryTreeNodeWithParent current = root;
            while (!q.isEmpty()) {
                current = q.remove();
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            return current;
        }

        private static void insert(BinaryTreeNodeWithParent node) throws Exception {
            if (root == null) {
                root = node;
                return;
            }

            BinaryTreeNodeWithParent nextParent = getNextParent();
            if (nextParent.left == null) {
                nextParent.left = node;
                node.parent = nextParent;
            } else if (nextParent.right == null) {
                nextParent.right = node;
                node.parent = nextParent;
            } else {
                throw new Exception("Tree completeness does not exist");
            }


            while (nextParent != null && nextParent.value > node.value) {
                //update grandParent to point to this node
                if (nextParent.parent != null) {
                    if (nextParent.parent.left == nextParent) {
                        nextParent.parent.left = node;

                    } else {
                        nextParent.parent.right = node;
                    }
                }

                //Update current node to
                node.parent = nextParent.parent;
                BinaryTreeNodeWithParent temp;
                if (nextParent.left == node) {
                    if (node.left != null) node.left.parent = nextParent;//needed to move node in middle
                    nextParent.left = node.left;
                    node.left = nextParent;

                    if (nextParent.right != null) {
                        temp = node.right;
                        node.right = nextParent.right;
                        nextParent.right = temp;
                        node.right.parent = node;
                    }
                } else {
                    if (node.right != null) node.right.parent = nextParent;//needed to move node in middle
                    nextParent.right = node.right;
                    node.right = nextParent;

                    if (nextParent.left != null) {
                        temp = node.left;
                        node.left = nextParent.left;
                        nextParent.left = temp;
                        node.left.parent = node;
                    }
                }
                //update parent to make it child node
                nextParent.parent = node;

                nextParent = node.parent;

            }
            if (node.parent == null)
                root = node;

        }

        private static BinaryTreeNodeWithParent remove() {
            if (root == null)
                return null;

            if (root.left == null && root.right == null) {
                BinaryTreeNodeWithParent toBeRemoved = root;
                root = null;
                return toBeRemoved;
            }
            BinaryTreeNodeWithParent oldRoot = root;
            BinaryTreeNodeWithParent newRoot = getLastNode();

            root = newRoot;
            if(newRoot.parent!=null){
                if(newRoot.parent.left==newRoot){
                    newRoot.parent.left=null;
                }else{
                    newRoot.parent.right=null;
                }
            }
            newRoot.parent=null;
            replace(oldRoot, newRoot);
            swapDown(newRoot);


            oldRoot.right = null;
            oldRoot.left = null;
            return oldRoot;
        }


        public static void replace(BinaryTreeNodeWithParent toBeReplaced, BinaryTreeNodeWithParent replacement) {
            if (toBeReplaced.left != null) {
                replacement.left = toBeReplaced.left;
                toBeReplaced.left.parent = replacement;
                toBeReplaced.left = null;
            }

            if (toBeReplaced.right != null) {
                replacement.right = toBeReplaced.right;
                toBeReplaced.right.parent = replacement;
                toBeReplaced.right = null;
            }
        }

        public static void swapDown(BinaryTreeNodeWithParent toSwapDown){
            if(toSwapDown.left==null&&toSwapDown.right==null) {
                return;
            }else if(toSwapDown.right==null && toSwapDown.left.value<toSwapDown.value){
                //Don't need to check if toSwapDown.left is the non-null argument because it has to be
                //toSwapDown.right can only have a value if toSwapDown.left has a values and because we
                //know both statements don't have a null value from the first if statement, this means toSwapDown must
                swap(toSwapDown,toSwapDown.left,true);
            }else{
                if(toSwapDown.left.value<toSwapDown.right.value&&toSwapDown.left.value<toSwapDown.value){
                    swap(toSwapDown,toSwapDown.left,true);
                }else if (toSwapDown.right.value < toSwapDown.left.value&&toSwapDown.left.value<toSwapDown.value){
                    swap(toSwapDown,toSwapDown.right,false);
                }
            }
            swapDown(toSwapDown);
        }

        public static void swap(BinaryTreeNodeWithParent toSwapDown, BinaryTreeNodeWithParent replacement, boolean replacementIsleftChild){
            //changes swapsDown's parent to point to new child
            if(toSwapDown.parent!=null){
                if(toSwapDown.parent.left==toSwapDown){
                    toSwapDown.parent.left=replacement;
                }else{
                    toSwapDown.parent.right=replacement;
                }
            }
            //change new child to point to swapDown's parent
            replacement.parent=toSwapDown.parent;

            //change swapDown parent to point to previous child
            toSwapDown.parent=replacement;

            // swap children of swapDown and replacement
            //if replacement is swapDowns left child, the replacement needs to swap its right child with swapDown
            //if replacement is swapDowns right child, the replacement needs to swap its left child with swapDown
            if(replacementIsleftChild){
                BinaryTreeNodeWithParent temp = toSwapDown.right;
                toSwapDown.right.parent=replacement;
                toSwapDown.right=replacement.right;
                replacement.right.parent=toSwapDown;
                replacement.right=temp;
            }else{
                BinaryTreeNodeWithParent temp = toSwapDown.left;
                toSwapDown.left.parent=replacement;
                toSwapDown.left=replacement.left;
                replacement.left.parent=toSwapDown;
                replacement.left=temp;
            }
        }
    }

    @Test
    public void insertIntoTree() throws Exception {
        BinaryTreeNodeWithParent root = new BinaryTreeNodeWithParent(6);
        BinaryTreeNodeWithParent node1 = new BinaryTreeNodeWithParent(8);
        BinaryTreeNodeWithParent node2 = new BinaryTreeNodeWithParent(5);
        BinaryTreeNodeWithParent node3 = new BinaryTreeNodeWithParent(1);
        BinaryTreeNodeWithParent node4 = new BinaryTreeNodeWithParent(43);
        BinaryTreeNodeWithParent node5 = new BinaryTreeNodeWithParent(57);
        BinaryTreeNodeWithParent node6 = new BinaryTreeNodeWithParent(9);
        BinaryTreeNodeWithParent node7 = new BinaryTreeNodeWithParent(-8);

        MinHeap.insert(root);
        MinHeap.insert(node1);
        MinHeap.insert(node2);
        MinHeap.insert(node3);
        MinHeap.insert(node4);
        MinHeap.insert(node5);
        MinHeap.insert(node6);
        MinHeap.insert(node7);

        BinaryTreeNodeWithParent.printBreadthFirst(MinHeap.root);
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
