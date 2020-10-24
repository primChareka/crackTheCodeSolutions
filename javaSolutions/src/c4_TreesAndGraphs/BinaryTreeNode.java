package c4_TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BinaryTreeNode {
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public static void printBreadthFirst(BinaryTreeNode root){
        Deque<BinaryTreeNode> q= new ArrayDeque<>();
        q.add(root);
        int nodesAtLevel = 1;
        int nextLevel=0;

        while(!q.isEmpty()){
            if(nodesAtLevel==0){
                nodesAtLevel = nextLevel;
                nextLevel = 0;
                System.out.println();
            }

            BinaryTreeNode current  = q.remove();
            System.out.print(current.value + "\t");
            nodesAtLevel--;
            if(current.left!=null){
                q.add(current.left);
                nextLevel++;
            }

            if(current.right!=null){
                q.add(current.right);
                nextLevel++;
            }
        }
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

