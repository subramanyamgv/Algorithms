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
    }

    protected String expression;
    protected TreeNode root;
    protected int i = 0;

    public ParseTree(String expression) {
        this.expression = expression;
    }

    public abstract TreeNode construct();

    public abstract void print(TreeNode root);
}
