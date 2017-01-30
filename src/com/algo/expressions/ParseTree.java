package com.algo.expressions;

/**
 * Created by Subramanyam on 13-Dec-2016.
 */
public abstract class ParseTree {

    public static class TreeNode {
        Character data;
        TreeNode left, right;

        public TreeNode(Character data) {
            this.data = data;
        }

        public TreeNode(Character data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    protected String expression;
    protected TreeNode root;
    protected int i = 0;

    public ParseTree(String expression) {
        this.expression = expression;
    }

    public abstract TreeNode construct();

    public double evaluate(TreeNode root) {

        if (root == null)
            return 0;

        switch (root.data) {
            case '+':
                return evaluate(root.left) + evaluate(root.right);
            case '*':
                return evaluate(root.left) * evaluate(root.right);
            case '-':
                return evaluate(root.left) - evaluate(root.right);
            case '/':
                return evaluate(root.left) / evaluate(root.right);
            default:
                return root.data - '0';
        }
    }

    public void preorder(TreeNode root) {

        if (root != null) {
            System.out.print(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(TreeNode root) {

        if (root != null) {
            postorder(root.left);
            System.out.print(root.data);
            postorder(root.right);
        }
    }

}
