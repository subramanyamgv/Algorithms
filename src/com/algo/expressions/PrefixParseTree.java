package com.algo.expressions;

/**
 * Created by Subramanyam on 13-Dec-2016.
 */
public class PrefixParseTree extends ParseTree {

    public PrefixParseTree(String expression) {
        super(expression);
    }

    /**
     * Create a parse tree from postfix expression
     * i/p: *+ab-cd
     * o/p:        *
     *           /  \
     *         +     -
     *       /  \   / \
     *      a    b c   d
     *
     * Use recursion and parse the expression right to left
     * @return root
     */
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

}
