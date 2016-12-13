package com.algo.expressions;

import static com.algo.ADT.*;

/**
 * Created by Subramanyam on 13-Dec-2016.
 */
public class Prefix {

    private String expression;

    public Prefix(String expression) {
        this.expression = expression;
    }

    public Prefix() {
    }

    /**
     * Convert parenthesised Infix expression to Prefix expression
     * i/p: (((a+b)*c)-d)
     * o/p: -*+abcd
     * Solution: Use stack
     * @param infixExpression
     * @return
     */
    public void fromInfix(String infixExpression) {

        Stack<Character> stack = new Stack<Character>();
        String prefix = "";

        for (int i = infixExpression.length() - 1 ; i >= 0 ; i--) {

            Character ch = infixExpression.charAt(i);

            if (Character.isLetter(ch)) {
                prefix = ch + prefix;
            } else if (ch.equals(')')) {
                continue;
            } else if (ch.equals('(')) {
                prefix = stack.pop() + prefix;
            } else { //Operator
                stack.push(ch);
            }
        }

        this.expression = prefix;
    }

    /**
     * Evaluate a prefix expression
     * i/p: -*+2354
     * o/p: 21
     * @return
     */
    public double eval() {

        Stack<Double> stack = new Stack<Double>();

        for (int i = expression.length() - 1 ; i >= 0 ; i--) {

            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push((double) (ch - '0'));
            } else if (ch == '+'){
                stack.push(stack.pop() + stack.pop());
            } else if (ch == '-'){
                stack.push(stack.pop() - stack.pop());
            } else if (ch == '*'){
                stack.push(stack.pop() * stack.pop());
            } else if (ch == '/'){
                stack.push(stack.pop() / stack.pop());
            }
        }

        return stack.pop();
    }

    public double evalRecursive() {
        return 0;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
