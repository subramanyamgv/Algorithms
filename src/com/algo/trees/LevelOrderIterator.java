package com.algo.trees;

import com.algo.ADT;

import java.util.Iterator;

/**
 * Level order traversal iterator
 * @param <E>
 */
class LevelOrderIterator<E> implements Iterator<E> {

    ADT.Queue<BST.TreeNode<E>> queue = new ADT.Queue<BST.TreeNode<E>>();
    BST.TreeNode<E> current;

    public LevelOrderIterator(BST.TreeNode<E> root) {
        current = root;
        queue.offer(current);
    }

    @Override
    public boolean hasNext() {

        current = queue.poll();

        if (current == null) {
            return false;
        }

        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);

        return true;
    }

    @Override
    public E next() {
        return current.data;
    }
}
