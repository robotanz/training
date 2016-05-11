package com.robotanz.training.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeNode: simple tree node with a int value.
 */
public class TreeNode implements ITreeNode {

    private ITreeNode parent = null;

    private final List<ITreeNode> children = new ArrayList<>(0);

    private final int value;

    public TreeNode(int value) {
        super();
        this.value = value;
    }

    @Override
    public void setParent(ITreeNode node) {
        this.parent = node;
    }

    @Override
    public ITreeNode getParent() {
        return parent;
    }

    @Override
    public ITreeNode getChild(int i) {

        if (children.size() >= i) {
            return null;
        }
        else {
            return children.get(i);
        }
    }

    @Override
    public void addChild(ITreeNode node) {
        children.add(node);
    }

    @Override
    public void removeChild(ITreeNode node) {
        children.remove(node);
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public int getCount() {
        return children.size();
    }

    @Override
    public int getValue() {
        return value;
    }
}
