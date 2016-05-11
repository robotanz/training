package com.robotanz.training.trees;

import com.robotanz.training.ArrayUtil;
import com.robotanz.training.sorters.HeapSort;

/**
 * BinarySearchTree:
 */
public class BinarySearchTree {

    private BSTNode root;

    public BinarySearchTree(int[] sortedArray) {

        root = buildTree(sortedArray, 0, sortedArray.length);
    }

    private BSTNode buildTree(final int[] array, int first, int length) {

        if (length == 0) {
            return null;
        }

        int middle = first + length / 2;
        BSTNode node = new BSTNode(array[middle]);

        // build left subtree
        int leftLength = middle - first;
        BSTNode left = buildTree(array, first, leftLength);
        if (left != null) {
            node.left = left;
            left.parent = node;
        }

        // build right subtree
        BSTNode right = buildTree(array, middle + 1, length - leftLength - 1);
        if (right != null) {
            node.right = right;
            right.parent = node;
        }

        return node;
    }

    BSTNode getRoot() {
        return root;
    }

    BSTNode search(int value) {
        return search(root, value);
    }

    /**
     * Recursive search
     *
     * @param node from node
     * @param value
     * @return matching node or <code>null</code> if not found
     */
    private BSTNode search(BSTNode node, int value) {

        if (node == null) {
            return null;
        }

        if (value < node.value) {
            return search(node.left, value);
        }
        else if (value > node.value) {
            return search(node.right, value);
        }

        // else value == node.value
        return node;
    }

    public static void main(String[] args) {
        int[] array = ArrayUtil.randomIntArray(50);

        int value = array[0];

        HeapSort sorter = new HeapSort();
        sorter.sort(array);

        BinarySearchTree tree = new BinarySearchTree(array);

        BSTNode node = tree.search(value);

        System.out.println(node == null ? "Not found" : "Found!");
    }
}
