package com.guvi;

public class TreeNodeGeneric<T> {
    private T value;
    private TreeNodeGeneric<T> left;
    private TreeNodeGeneric<T> right;

    public TreeNodeGeneric(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public TreeNodeGeneric<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNodeGeneric<T> left) {
        this.left = left;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNodeGeneric<T> getRight() {
        return right;
    }

    public void setRight(TreeNodeGeneric<T> right) {
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
