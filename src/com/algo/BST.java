package com.algo;

import java.util.Comparator;
import java.util.Iterator;

import static com.algo.ADT.*;

/**
 * Created by Subramanyam on 29-Nov-2016.
 */
public class BST<E> {

    Comparator<E> comparator;
    TreeNode<E> root;

    public enum TRAVERSAL {INORDER, PREORDER, POSTORDER, LEVELORDER};

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

    public Iterator<E> getIterator(TRAVERSAL traversal) {
        switch (traversal) {
            case INORDER:
                return new InorderIterator<E>(root);
            case PREORDER:
                return new PreorderIterator<E>(root);
            case POSTORDER:
                return new PostOrderIterator<E>(root);
            case LEVELORDER:
                return new LevelOrderIterator<E>(root);
            default:
                return null;
        }
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

    /**
     * Iterator for inorder traversal of Binary Search Tree
     * @param <E>
     */
    class InorderIterator<E> implements Iterator<E> {

        private Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
        private TreeNode<E> current;

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

    /**
     * Implements preorder traversal iterator
     */
    class PreorderIterator<E> implements Iterator<E> {

        private Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
        private TreeNode<E> current;

        public PreorderIterator(TreeNode<E> root) {
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
            TreeNode<E> temp = current;
            current = stack.pop();
            return temp.data;
        }
    }

    /**
     * TODO: Implement postorder traversal iterator
     */
    class PostOrderIterator<E> implements Iterator<E> {

        Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
        TreeNode<E> current;

        public PostOrderIterator(TreeNode<E> root) {
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

    /**
     * Level order traversal iterator
     * @param <E>
     */
    class LevelOrderIterator<E> implements Iterator<E> {

        Queue<TreeNode<E>> queue = new Queue<TreeNode<E>>();
        TreeNode<E> current;

        public LevelOrderIterator(TreeNode<E> root) {
            current = root;
            queue.put(current);
        }

        @Override
        public boolean hasNext() {

            current = queue.get();

            if (current == null) {
                return false;
            }

            if (current.left != null) queue.put(current.left);
            if (current.right != null) queue.put(current.right);

            return true;
        }

        @Override
        public E next() {
            return current.data;
        }
    }
}
