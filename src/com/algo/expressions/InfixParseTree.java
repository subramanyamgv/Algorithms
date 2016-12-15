package com.algo.expressions;

import static com.algo.ADT.*;

/**
 * Created by Subramanyam on 14-Dec-2016.
 */
public class InfixParseTree extends ParseTree {

    public InfixParseTree(String expression) {
        super(expression);
    }

    /**
     * Create a parse tree from infix expression
     * i/p: ((a+b)*(c-d))
     * o/p:        *
     *           /  \
     *         +     -
     *       /  \   / \
     *      a    b c   d
     *
     * Use two stacks: one for saving subtrees, and other for saving operators
     * @return root
     */
    @Override
    public TreeNode construct() {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Character> operator = new Stack<Character>();

        for (int i = 0 ; i < expression.length() ; i++) {

            char ch = expression.charAt(i);

            if (Character.isLetter(ch)) {
                stack.push(new TreeNode(ch));
            } else if (ch == '(') {
                continue;
            } else if (ch == ')') {
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                stack.push(new TreeNode(operator.pop(), left, right));
            } else {
                operator.push(ch);
            }
        }

        return stack.pop();
    }

}
