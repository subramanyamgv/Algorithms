package com.algo.trees;

import com.algo.ADT;

import java.util.Iterator;

/**
 * Iterator for inorder traversal of Binary Search Tree
 * @param <E>
 */
class InorderIterator<E> implements Iterator<E> {

    private ADT.Stack<BST.TreeNode<E>> stack = new ADT.Stack<BST.TreeNode<E>>();
    private BST.TreeNode<E> current;

    public InorderIterator(BST.TreeNode<E> root) {
        this.current = root;
    }

    @Override
    public boolean hasNext() {

        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();

        return current != null;
    }

    @Override
    public E next() {
        BST.TreeNode<E> temp = current;
        current = current.right;
        return temp.data;
    }
}
