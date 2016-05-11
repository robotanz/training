package com.robotanz.training.trees;

/**
 * Binary Search Tree Node
 */
public class BSTNode implements ITreeNode {

    ITreeNode parent = null;

    final int value;

    BSTNode left;

    BSTNode right;

    public BSTNode(int value) {
        super();
        this.value = value;
    }

    @Override
    public void setParent(ITreeNode node) {
        parent = node;
    }

    @Override
    public ITreeNode getParent() {
        return parent;
    }

    @Override
    public ITreeNode getChild(int i) {

        if (i == 0) {
            return left;
        }
        if (i == 1) {
            return right;
        }

        return null;
    }

    @Override
    public void addChild(ITreeNode node) {
    }

    @Override
    public void removeChild(ITreeNode node) {
        if (left.equals(node)) {
            left = null;
            node.setParent(null);
        }
        else if (right.equals(node)) {
            right = null;
            node.setParent(null);
        }
    }

    @Override
    public boolean hasChildren() {
        return left != null || right != null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public int getValue() {
        return value;
    }
}
