package com.algo.expressions;

/**
 * Created by Subramanyam on 13-Dec-2016.
 */
public class PrefixParseTree extends ParseTree {

    public PrefixParseTree(String expression) {
        super(expression);
    }

    @Override
    public TreeNode construct() {

        char ch = expression.charAt(i++);

        TreeNode t = new TreeNode(ch);

        if (ch == '*' || ch == '+' || ch == '-' || ch == '/') {
            t.left = construct();
            t.right = construct();
        }

        return t;
    }

    @Override
    public void print(TreeNode root) {
        if (root != null) {
            System.out.print(root.data);
            print(root.left);
            print(root.right);
        }
    }

}
