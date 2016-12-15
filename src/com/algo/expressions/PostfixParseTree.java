package com.algo.expressions;

/**
 * Created by Subramanyam on 13-Dec-2016.
 */
public class PostfixParseTree extends ParseTree {

    public PostfixParseTree(String expression) {
        super(expression);
        i = expression.length();
    }

    /**
     * Create a parse tree from postfix expression
     * i/p: ab+cd-*
     * o/p:        *
     *           /  \
     *         +     -
     *       /  \   / \
     *      a    b c   d
     *
     * Use recursion and parse the expression left to right
     * @return root
     */
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

}
