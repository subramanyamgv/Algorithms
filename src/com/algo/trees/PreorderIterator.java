package com.algo.trees;

import com.algo.ADT;

import java.util.Iterator;

/**
 * Implements preorder traversal iterator
 */
class PreorderIterator<E> implements Iterator<E> {

    private ADT.Stack<BST.TreeNode<E>> stack = new ADT.Stack<BST.TreeNode<E>>();
    private BST.TreeNode<E> current;

    public PreorderIterator(BST.TreeNode<E> root) {
        this.current = root;
    }

    @Override
    public boolean hasNext() {

        if (current == null)
            return false;

        if (current.right != null) stack.push(current.right);
        if (current.left != null) stack.push(current.left);

        return true;
    }

    @Override
    public E next() {
        BST.TreeNode<E> temp = current;
        current = stack.pop();
        return temp.data;
    }
}
