package com.guvi;

import java.util.ArrayList;
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
    public static void collectSubTreeValues(TreeNode node, List<Integer> output) {
        // Base case
        if(node == null) {
            return;
        }

        // Add to output
        output.add(node.getValue());

        // Recursive call
        collectSubTreeValues(node.getLeft(), output);
        collectSubTreeValues(node.getRight(), output);
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();

        System.out.println("Value of the root: " + root.getValue());
        System.out.println("Left Child: " + root.getLeft().toString());
        System.out.println("Right Child: " + root.getRight().toString());

        System.out.println("Left child of 2: " + root.getLeft().getLeft().toString());

        List<Integer> result = new ArrayList<>();
        // Pass by reference
        collectSubTreeValues(root, result);
        System.out.println(result);

    }
}
