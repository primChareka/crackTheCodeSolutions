package c4_TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeNodeWithParent {
    public int value;
    public BinaryTreeNodeWithParent left;
    public BinaryTreeNodeWithParent right;
    public BinaryTreeNodeWithParent parent;

    public BinaryTreeNodeWithParent(int value) {
        this.value = value;
    }

    public BinaryTreeNodeWithParent insertLeft(int leftValue) {
        this.left = new BinaryTreeNodeWithParent(leftValue);
        return this.left;
    }

    public BinaryTreeNodeWithParent insertRight(int rightValue) {
        this.right = new BinaryTreeNodeWithParent(rightValue);
        return this.right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNodeWithParent getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNodeWithParent left) {
        this.left = left;
    }

    public BinaryTreeNodeWithParent getRight() {
        return right;
    }

    public void setRight(BinaryTreeNodeWithParent right) {
        this.right = right;
    }

    public BinaryTreeNodeWithParent getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNodeWithParent parent) {
        this.parent = parent;
    }

    public static void printBreadthFirst(BinaryTreeNodeWithParent root){
        Deque<BinaryTreeNodeWithParent> q= new ArrayDeque<>();
        q.add(root);
        int nodesAtLevel = 1;
        int nextLevel=0;

        while(!q.isEmpty()){
            if(nodesAtLevel==0){
                nodesAtLevel = nextLevel;
                nextLevel = 0;
                System.out.println();
            }

            BinaryTreeNodeWithParent current  = q.remove();
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

}

