package com.algo.trees;

import com.algo.ADT;

import java.util.Iterator;

/**
 * TODO: Implement postorder traversal iterator
 */
class PostOrderIterator<E> implements Iterator<E> {

    ADT.Stack<BST.TreeNode<E>> stack = new ADT.Stack<BST.TreeNode<E>>();
    BST.TreeNode<E> current;

    public PostOrderIterator(BST.TreeNode<E> root) {
        this.current = root;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
