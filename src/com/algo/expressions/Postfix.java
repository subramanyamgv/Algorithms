package com.algo.expressions;

import static com.algo.ADT.*;

/**
 * Created by Subramanyam on 13-Dec-2016.
 */
public class Postfix {

    private String expression;

    public Postfix(String expression) {
        this.expression = expression;
    }

    public Postfix() {
    }

    /**
     * Convert parenthesised Infix expression to Postfix expression
     * i/p: (((a+b)*c)-d)
     * o/p: ab+c*d-
     * Solution: Use stack
     * @param infixExpression
     * @return
     */
    public void fromInfix(String infixExpression) {

        Stack<Character> stack = new Stack<Character>();
        String postfix = "";

        for (int i = 0 ; i < infixExpression.length() ; i++) {

            Character ch = infixExpression.charAt(i);

            if (Character.isLetter(ch)) {
                postfix += ch;
            } else if (ch.equals(')')) {
                postfix += stack.pop();
            } else if (ch.equals('(')) {
                continue;
            } else {
                stack.push(ch);
            }
        }

        this.expression = postfix;
    }

    /**
     * Evaluate a postfix expression
     * i/p: 23+5*4-
     * o/p: 21
     * @return
     */
    public double eval() {

        Stack<Double> stack = new Stack<Double>();

        for (int i = 0 ; i < expression.length() ; i++) {

            Character ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push((double)(ch - '0'));
            } else {

                double val = stack.pop();

                if (ch.equals('+')) {
                    val = stack.pop() + val;
                } else if (ch.equals('-')) {
                    val = stack.pop() - val;
                } else if (ch.equals('*')) {
                    val = stack.pop() * val;
                } else if (ch.equals('/')) {
                    val = stack.pop() / val;
                }

                stack.push(val);
            }
        }

        return stack.pop();
    }

    /**
     * TODO: Evaluate postfix expression recursively
     * @return
     */
    public double evalRecursive() {
        return 0;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
