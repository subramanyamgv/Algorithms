package com.algo;

import sun.reflect.generics.tree.Tree;

import java.time.temporal.Temporal;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Subramanyam on 29-Nov-2016.
 */
public class BST<E> {

    Comparator<E> comparator;
    TreeNode<E> root;

    public static class TreeNode<E> {

        E data;
        TreeNode<E> left, right;

        public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
            this.data = data; this.left = left; this.right = right;
        }

        public TreeNode(E data) {
            this(data, null, null);
        }
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public Iterator<E> getInorderIterator() {
        return new InorderIterator<E>(root);
    }

    public void init(E[] items) {

        root = null;

        for (E item : items) {
            insert(item);
        }
    }

    public void insert(E data) {

        TreeNode<E> temp = root;

        if (root == null) {
            root = new TreeNode<E>(data);
            return;
        }

        while (comparator.compare(temp.data, data) != 0) {

            if (comparator.compare(temp.data, data) > 0) {

                if (temp.left == null)
                    temp.left = new TreeNode<E>(data);

                temp = temp.left;

            } else if (comparator.compare(temp.data, data) < 0) {

                if (temp.right == null)
                    temp.right = new TreeNode<E>(data);

                temp = temp.right;
            }
        }
    }

    /**
     * Get item at position pos
     * @param pos
     * @return
     */
    public E getItem(int pos) {
        return null;
    }


    /**
     * Find data in BST
     * @param data
     * @return
     */
    public E find(E data) {

        TreeNode<E> temp = root;

        while (temp != null) {

            if (comparator.compare(data, temp.data) == 0) {
                return temp.data;
            }

            temp = (comparator.compare(data, temp.data) < 0) ?
                    temp.left :
                    temp.right;
        }

        return null;
    }

    /**
     * Find data in BST recursively
     * @param data
     * @return
     */
    public E findRecursive(E data) {
        return _findRecursive(root, data);
    }

    private E _findRecursive(TreeNode<E> root, E data) {

        if (root == null)
            return null;

        if (comparator.compare(root.data, data) == 0)
            return data;

        if (comparator.compare(data, root.data) < 0) {
            return _findRecursive(root.left, data);
        } else {
            return _findRecursive(root.right, data);
        }
    }

    class InorderIterator<E> implements Iterator<E> {

        ADT.Stack<TreeNode<E>> stack = new ADT.Stack<TreeNode<E>>();
        TreeNode<E> current;

        public InorderIterator(TreeNode<E> root) {
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
            TreeNode<E> temp = current;
            current = current.right;
            return temp.data;
        }
    }

}
