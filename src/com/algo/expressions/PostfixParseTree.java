package com.algo.expressions;

/**
 * Created by Subramanyam on 13-Dec-2016.
 */
public class PostfixParseTree extends ParseTree {

    public PostfixParseTree(String expression) {
        super(expression);
        i = expression.length();
    }

    @Override
    public TreeNode construct() {

        char ch = expression.charAt(--i);

        TreeNode t = new TreeNode(ch);

        if (ch == '*' || ch == '+' || ch == '-' || ch == '/') {
            t.right = construct();
            t.left = construct();
        }

        return t;
    }

    @Override
    public void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            print(root.right);
            System.out.print(root.data);
        }
    }

}
