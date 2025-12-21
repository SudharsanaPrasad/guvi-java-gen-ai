package com.guvi;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;
    private int count;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public boolean isLeaf() {
        if(left == null && right == null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TreeNode: [value=" + value + "]";
    }
}
