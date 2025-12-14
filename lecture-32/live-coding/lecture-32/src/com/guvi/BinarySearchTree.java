package com.guvi;

import java.util.Comparator;

public class BinarySearchTree<T> {
    private TreeNodeGeneric<T> root;
    private int size;

    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        root = null;
        size = 0;
        this.comparator = comparator;
    }

    // size
    public int size() {
        return size;
    }

    // isEmpty
    public boolean isEmpty() {
        return root == null;
    }

    public int compare(T a, T b) {
        return comparator.compare(a, b);
    }

    // contains - search(target)
    /**
     * start at the root
     *  if the target equals the current node -> found!
     *  if the target is smaller than the current node -> go left
     *  if the target is greater than the current node -> go right
     *  if we hit a null -> not found
     */
    public boolean contains(T target) {
        if(value == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        return contains(root, value);
    }

    private boolean contains(TreeNodeGeneric<T> node, T target) {
        // Base Case
        if(node == null) {
            return false;
        }
        // Intermediate steps - comparison
        int cmp = compare(node.getValue(), target);

        // Found the target
        if(cmp == 0) {
            return true;
        }

        // Recursive
        if(cmp < 0) {
            return contains(node.getRight(), target);
        }

        // search on the left side
        //if(cmp > 0) {
        return contains(node.getLeft(), target);
        //}
    }

    // insertion
    /**
     * Intent: add a new value while keeping BST ordering correct
     *
     * Key Idea:
     *  Insertion is basically "searching for the correct spot" in the BST
     *
     *  Duplicates: reject them
     */
    public boolean insert(T value) {
        // validate input

        int prevSize = size;
        // recursive insert
        root = insert(root, value);
        // compare whether size has changed
        if(size > prevSize) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Base case: node == null -> we found the insertion spot; create a new node w/ the value
     * Otherwise:
     *  - value < current node => insert value in the left subtree
     *  - value > current node => insert value in the right subtree
     *  - value == current node => duplicate; do nothing
     *
     * @param node
     * @param target
     * @return
     */
    private TreeNodeGeneric<T> insert(TreeNodeGeneric<T> node, T value) {
        // Base case
        if(node == null) {
            TreeNodeGeneric<T> newNode = new TreeNodeGeneric<>(value);
            size++;
            return newNode;
        }

        // Comparison
        int cmp = compare(value, node.getValue());
        if(cmp < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if(cmp > 0) {
            node.setRight(insert(node.getRight(), value));
        } else {
            // Duplicate: do nothing
        }
        return node;
    }

    // delete

    /**
     * Intent: delete a value while keeping BST ordering correct
     *
     * Key Idea:
     *  - First, we "search" for the node to delete using comparisons
     *  - Once found, we handle a couple cases
     *
     *  Case 1) Leaf Node (0 children)
     *      - Remove it by return null
     *  Case 2) One child
     *      - Replace the node we're deleting with the sole child
     *  Case 3) Two children
     *      - Replace the node's value with its inorder successor (smallest in the right subtree)
     *      - Delete the successor from the right subtree
     * @param value
     * @return
     */
    public boolean delete(T value) {
        // validations

        int prevSize = size;
        root = delete(root, value);
        // return true if delete is success
        if(prevSize > size) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Base case => node == null => we haven't found the node to delete
     *
     * @param node
     * @param value
     * @return
     */
    private TreeNodeGeneric<T> delete(TreeNodeGeneric<T> node, T value) {
        if(node == null) {
            return null;
        }

        int cmp = compare(value, node.getValue());
        if(cmp < 0) {
            node.setLeft(delete(node.getLeft(), value));
            return node;
        }

        if(cmp > 0) {
            node.setRight(delete(node.getRight(), value));
            return node;
        }

        // default: we have found the node to delete
        // Case 1: leaf node
        if(node.getLeft() == null && node.getRight() == null) {
            size--;
            return null;
        }
        // Case 2: 1 child -> left OR right child
        if(node.getRight() == null) {
            size--;
            return node.getLeft();
        }

        if(node.getLeft() == null) {
            size--;
            return node.getRight();
        }

        // Case 3: 2 children -> find the successor
        // use inorder successor (min of the right subtree)
        TreeNodeGeneric<T> successor = findMin(node.getRight());

        // Replace the current node's value with the successor's value
        node.setValue(successor.getValue());

        // Delete the successor
        node.setRight(delete(node.getRight(), successor.getValue()));

        return root;
    }

    private TreeNodeGeneric<T> findMin(TreeNodeGeneric<T> right) {
        return null;
    }

}
