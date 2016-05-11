package com.robotanz.training.trees;

public interface ITreeNode {

    void setParent(ITreeNode node);

    ITreeNode getParent();

    ITreeNode getChild(int i);

    void addChild(ITreeNode node);

    void removeChild(ITreeNode node);

    boolean hasChildren();

    int getCount();

    int getValue();
}
