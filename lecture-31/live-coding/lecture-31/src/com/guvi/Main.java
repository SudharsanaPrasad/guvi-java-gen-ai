package com.guvi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static TreeNode buildSampleTree() {
        // Creating a binary tree
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        return node1;
    }

    // why's the return void?
        // output is not returned because the original List is updated
        // via pass by reference
    // Not iterative; Recursive traversal
    public static void preOrder(TreeNode node, List<Integer> output) {
        // Base case
        if(node == null) {
            return;
        }

        // Add to output
        output.add(node.getValue());

        // Recursive call
        preOrder(node.getLeft(), output);
        preOrder(node.getRight(), output);
    }

    public static void inOrder(TreeNode node, List<Integer> output) {
        // Base case
        if(node == null) {
            return;
        }
        // explore left
        inOrder(node.getLeft(), output);
        // visit the node
        output.add(node.getValue());
        // explore right
        inOrder(node.getRight(), output);

    }

    public static void postOrder(TreeNode node, List<Integer> output) {
        // Base case
        if(node == null) {
            return;
        }
        // explore left
        postOrder(node.getLeft(), output);
        // explore right
        postOrder(node.getRight(), output);
        // visit the node
        output.add(node.getValue());
    }

    public static List<List<Integer>> levelOrder(TreeNode node) {
        // List<Integer> output = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        // what if the node is null?
        if(node == null) {
            return output;
        }

        // create a queue
        Deque<TreeNode> queue = new ArrayDeque<>();
        // add the root node to the queue
        queue.addLast(node);

        // as long as the queue isn't empty
        while(!queue.isEmpty()) {
            // process each node in the queue

            // size of our queue -> size of the level
            int levelSize = queue.size();
            // compose the inner List<Integer>
            List<Integer> level = new ArrayList<>(levelSize);

            // given the size of the level, process nodes in that level
            for(int i = 0; i < levelSize; i++) {
                // remove from the beginning
                TreeNode current = queue.removeFirst();
                level.add(current.getValue());

                if(current.getLeft() != null) {
                    queue.addLast(current.getLeft());
                }

                if(current.getRight() != null) {
                    queue.addLast(current.getRight());
                }
            }
            output.add(level);
        }
        return output;
    }

    public static TreeNode buildTree(List<Integer> preOrder, List<Integer>  inOrder) {
        // validation

        // track the pre-order index
        int preOrderIndex = 0;
        // track the in-order index
        HashMap<Integer, Integer> inorderIndex = new HashMap<>();
        for(var i = 0; i < inOrder.size(); i++) {
            inorderIndex.put(inOrder.get(i), i);
        }

        buildSubtree(preOrder, inorderIndex, 0, inOrder.size());

    }

    public static TreeNode buildSubtree(List<Integer> preorder, HashMap<Integer, Integer> inorderIndex,
                                  int inLeft, int inRight) {
        // base case - empty inorder slice, that means there's no subtree to create

        // Root comes from the next element in preorder
        // Root -> Left, Right

        // Split inorder output around the root to decide
        // the left vs right subtrees

        // recursive calls
        // build the left subtree -> recursion
        // build the right subtree -> recursion

        // determine the root node
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();

        //System.out.println("Value of the root: " + root.getValue());
        //System.out.println("Left Child: " + root.getLeft().toString());
        //System.out.println("Right Child: " + root.getRight().toString());

        //System.out.println("Left child of 2: " + root.getLeft().getLeft().toString());

        List<Integer> result = new ArrayList<>();
        // Pass by reference
        preOrder(root, result);
        // System.out.println(result);

        List<Integer> inOrderOutput = new ArrayList<>();
        inOrder(root, inOrderOutput);
        // System.out.println(inOrderOutput);

        List<Integer> postOrderOutput = new ArrayList<>();
        postOrder(root, postOrderOutput);
        //System.out.println("Output of post order: " + postOrderOutput);

        System.out.println("Output of level order: " + levelOrder(root));
    }
}
