package com.algo.trees;

import com.algo.LinkedList;

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

        public E getData() {
            return data;
        }
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BST(TreeNode<E> root, Comparator<E> comparator) {
        this.root = root;
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

    public TreeNode<E> getRoot() {
        return root;
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
    public E findRecursive(TreeNode<E> root, E data) {

        if (root == null)
            return null;

        if (comparator.compare(root.data, data) == 0)
            return data;

        if (comparator.compare(data, root.data) < 0) {
            return findRecursive(root.left, data);
        } else {
            return findRecursive(root.right, data);
        }
    }

    private boolean _isLeaf(TreeNode<E> root) {
        return root.left == null && root.right == null;
    }

    /**
     * Count nodes
     * @return
     */
    public int size(TreeNode<E> root) {
        return root == null ? 0 : 1 + size(root.left) + size(root.right);
    }

    /**
     * Count leaves
     * @return
     */
    public int leavesCount(TreeNode<E> root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) //Leaf
            return 1;
        return leavesCount(root.left) + leavesCount(root.right);
    }

    public int height(TreeNode<E> root) {

        if (root == null)
            return 0;

        int m = height(root.left);
        int n = height(root.right);

        return 1 + ((m > n) ? m : n);
    }

    /**
     * Calculate the height of the Binary Tree iteratively
     * @return
     */
    public int heightIterative() {

        int height = 0;
        Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
        TreeNode<E> temp = root;

        while (temp != null || !stack.isEmpty()) {

            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {

                while (!stack.isEmpty() && (temp == stack.peek().right))
                    temp = stack.pop();

                temp = (stack.isEmpty()) ? null : stack.peek().right;
            }

            if (stack.getCount() > height)
                height = stack.getCount();
        }

        return height;
    }

    /**
     * Create mirror/horizontal flip/Invert of a binary tree
     */
    public void mirror() {
        root = _mirror(root);
    }

    public TreeNode<E> _mirror(TreeNode<E> root) {

        if (root != null) {
            TreeNode<E> temp = root.right;
            root.right = _mirror(root.left);
            root.left = _mirror(temp);
        }

        return root;
    }

    /**
     * Iterative version of mirroring a Binary Tree
     */
    public void mirrorIterative() {

        if (root == null)
            return;

        Queue<TreeNode<E>> queue = new Queue<TreeNode<E>>();
        queue.put(root);

        while (!queue.isEmpty()) {

            TreeNode<E> current = queue.get();

            TreeNode<E> temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) queue.put(current.left);
            if (current.right != null) queue.put(current.right);
        }
    }

    /**
     * Clone (Copy) a Binary Tree
     * @param comparator
     * @return
     */
    public BST<E> clone(Comparator<E> comparator) {
        return new BST<E>(_clone(root), comparator);
    }

    private TreeNode<E> _clone(TreeNode<E> root) {
        return (root == null) ? null :
                new TreeNode<E>(root.data, _clone(root.left), _clone(root.right));
    }

    public BST<E> cloneIterative(Comparator<E> comparator) {

        Queue<TreeNode<E>> Qorg = new Queue<TreeNode<E>>();
        Queue<TreeNode<E>> Qclone = new Queue<TreeNode<E>>();

        TreeNode<E> cloneRoot = new TreeNode<E>(root.data);

        Qorg.put(root);
        Qclone.put(cloneRoot);

        while (!Qorg.isEmpty()) {

            TreeNode<E> Corg = Qorg.get();
            TreeNode<E> Cclone = Qclone.get();

            if (Corg.left != null) {
                Cclone.left = new TreeNode<E>(Corg.left.data);
                Qorg.put(Corg.left);
                Qclone.put(Cclone.left);
            }

            if (Corg.right != null) {
                Cclone.right = new TreeNode<E>(Corg.right.data);
                Qorg.put(Corg.right);
                Qclone.put(Cclone.right);
            }
        }

        return new BST<E>(cloneRoot, comparator);
    }

    /**
     * Check if bst is equal to the current BST
     * @param bst
     * @return
     */
    public boolean areEqual(BST<E> bst) {
        return _areEqual(bst.getRoot(), root);
    }

    private boolean _areEqual(TreeNode<E> root1, TreeNode<E> root2) {

        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return ((comparator.compare(root1.data, root2.data) == 0) &&
                _areEqual(root1.left, root2.left) &&
                _areEqual(root1.right, root2.right));
    }


    public boolean areEqualIterative(BST<E> bst) {

        if (root == null && bst.root == null) return true;
        if (root == null || bst.root == null) return false;

        Queue<TreeNode<E>> Q1 = new Queue<TreeNode<E>>();
        Queue<TreeNode<E>> Q2 = new Queue<TreeNode<E>>();

        Q1.put(root); Q2.put(bst.root);

        while (!Q1.isEmpty() && !Q2.isEmpty()) {

            TreeNode<E> T1 = Q1.get();
            TreeNode<E> T2 = Q2.get();

            if (comparator.compare(T1.data, T2.data) != 0)
                return false;

            if (T1.left != null || T2.left != null) {
                if (T1.left != null && T2.left != null) {
                    Q1.put(T1.left); Q2.put(T2.left);
                } else {
                    return false;
                }
            }

            if (T1.right != null || T2.right != null) {
                if (T1.right != null && T2.right != null) {
                    Q1.put(T1.right); Q2.put(T2.right);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check if BST is mirror equal to current BST
     * @param bst
     * @return
     */
    public boolean isMirrorEqual(BST<E> bst) {
        return _isMirrorEqual(bst.getRoot(), root);
    }

    private boolean _isMirrorEqual(TreeNode<E> root1, TreeNode<E> root2) {

        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return ((comparator.compare(root1.data, root2.data) == 0) &&
                _isMirrorEqual(root1.left, root2.right) &&
                _isMirrorEqual(root1.right, root2.left));
    }

    public boolean isBST() {
        return _isBST(root);
    }

    private boolean _isBST(TreeNode<E> root) {

        return (root == null) ||
                (
                    (root.left != null) && (comparator.compare(root.left.data, root.data) < 0) &&
                    (root.right != null) && (comparator.compare(root.right.data, root.data) > 0) &&
                    _isBST(root.left) && _isBST(root.right)
                );
    }

    public LinkedList<E> inorderTraversal(Stack.StackListener<TreeNode<E>> listener) {

        LinkedList<E> inList = new LinkedList<E>();
        Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();

        TreeNode<E> temp = root;

        while (temp != null || !stack.isEmpty()) {

            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                inList.insertEnd(temp.data);
                temp = temp.right;
            }

            listener.updated(stack);
        }

        return inList;
    }

    public LinkedList<E> preorderTraversal(Stack.StackListener<TreeNode<E>> listener) {

        LinkedList<E> inList = new LinkedList<E>();
        Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();

        TreeNode<E> temp = root;

        while (temp != null || !stack.isEmpty()) {

            if (temp != null) {

                inList.insertEnd(temp.data);

                if (temp.right != null)
                    stack.push(temp.right);

                temp = temp.left;
            } else {
                temp = stack.pop();
            }

            listener.updated(stack);
        }

        return inList;
    }

    public LinkedList<E> postOrderTraversal(Stack.StackListener<TreeNode<E>> listener) {

        LinkedList<E> list = new LinkedList<E>();
        Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();

        TreeNode<E> temp = root;

        while (temp != null || ! stack.isEmpty()) {

            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                while (!stack.isEmpty() && (temp == stack.peek().right)) {
                    temp = stack.pop();
                    list.add(temp.data);
                }

                temp = (stack.isEmpty()) ? null : stack.peek().right;
            }

            listener.updated(stack);
        }

        return list;
    }
}
