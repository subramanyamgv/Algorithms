package com.algo;

import java.util.Random;

import com.algo.adt.*;

/**
 * Created by Subramanyam on 23-Nov-2016.
 *
 * TODO:
 * (1) Find median of a stream of numbers:
 *      http://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/
 *      http://stackoverflow.com/questions/10657503/find-running-median-from-a-stream-of-integers
 * (2)
 */
public class Arrays {

//    /** Find pairs with given sum in sorted array of positive numbers
//    *   E.g., Input : [1, 2, 4, 5, 6, 8, 9]
//    *   x = 7
//    *   Output: (6, 1), (5,2)
//    */


    char array[] = new char[10];

    /**
     * Print all possible strings of length k that can be formed from a set of n characters
     * @param a
     * @param i
     * @param k
     */
    public void printAllStrings(char a[], int i, int k) {

        if (i == k) {
            System.out.println(array);
            return;
        }

        for (int j = 0 ; j < a.length ; j++) {
            array[i] = a[j];
            printAllStrings(a, i + 1, k);
        }
    }

    /**
     * Return Kth permutation
     * @param a
     * @param k
     */
    public char[] printKthPermutation(char a[], int k) {
        return null;
    }

    /**
     * Program to remove duplicates in sorted array
     * @param a
     * @return
     */
    //1, 2, 2, 2, 3, 3, 3, 4
    public int removeDuplicatesInSortedArray(int[] a) {

        int j = 0;
        for (int i = 1 ; i < a.length ; i++) {
            if (a[j] != a[i]) {
                a[++j] = a[i];
            }
        }

        return j+1;
    }

    /**
     * TODO: Program to find index where sum of both ends are equal
     * Assume all numbers are positive
     * @param a
     * @return
     */
    public int findBalancedIndex(int[] a) {
        return 0;
    }

    /**
     * Program to find index where sum of both ends are equal
     * Assume all numbers are positive or negative
     * Solution: Traverse the array and find the cummulative sum
     * and then retraverse the array and return i if a[i-1] == a[n-1] - a[i]
     * @param a
     * @return
     */
    public int findBalancedIndex2(int[] a) {

        for (int i = 1 ; i < a.length ; i++) {
            a[i] = a[i] + a[i-1];
        }

        for (int i = 1 ; i < a.length ; i++){
            if (a[i-1] == a[a.length-1] - a[i]) {
                return i;
            }
        }

        return -1;
    }


    public void reverse(char[] a, int low, int high) {
        if (low < high) {
            char t = a[low];
            a[low] = a[high];
            a[high] = t;
            reverse(a, low + 1, high - 1);
        }

    }

    public boolean isPalindrome(String string) {
        int N = string.length();
        for (int i = 0 ; i < N/2 ; i++) {
            if (string.charAt(i) != string.charAt(N - i - 1))
                return false;
        }
        return true;
    }

    public boolean isSorted (int[] a) {

        for (int i = 1; i < a.length ; i++) {
            if (a[i-1] > a[i])
                return false;
        }
        return true;
    }

    /**
     * Evaluate expression
     * @param exp
     * @return
     */
    public double evaluateExpression(String exp) {

        int len = exp.length();

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        int i = 0;
        while (i < len) {

            char ch = exp.charAt(i);

            if (ch == '+') ops.push("+");
            else if (ch == '*') ops.push("*");
            else if (ch == '/') ops.push("/");
            else if (ch == '-') ops.push("-");
            else if (ch == ')') {
                String op = ops.pop();
                double v = vals.pop();

                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("/")) v = vals.pop() / v;
                vals.push(v);

            } else if (Character.isDigit(ch)) {

                double value = 0.0;
                do {
                    value = value * 10 + Character.getNumericValue(ch);
                    i = i + 1;
                    ch = exp.charAt(i);
                } while (Character.isDigit(ch));
                i = i - 1;
                vals.push(value);
            }

            i = i + 1;
        }

        return vals.pop();
    }

    /**
     * Check if expression is balanced with ()
     * @param exp
     * @return
     */
    public boolean isExpressionBalanced(String exp) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0 ; i < exp.length() ; i++) {

            char ch = exp.charAt(i);

            if (ch == '(') stack.push(ch);
            else if (ch == ')' && stack.pop() != '(')
                return false;
        }

        return stack.isEmpty();
    }

    /**
     * Check if expression is balanced with ({[]})
     * @param exp
     * @return
     */
    public boolean isExpressionBalanced2(String exp) {

        Stack<Character> stack = new Stack<Character>();
        String open = "([{";
        String closed = ")]}";

        for (int i = 0 ; i < exp.length() ; i++) {

            char ch = exp.charAt(i);

            if (open.contains(ch+""))
                stack.push(ch);
            else if (closed.contains(ch+"")&& (ch != stack.pop())) {
                return false;
            }
        }

        return stack.isEmpty();
    }

//    public double evaluatePostfix(String exp) {
//
//        Stack<Double> vals = new Stack<Double>();
//
//        int i = 0;
//        while (i < exp.length()) {
//
//            char ch = exp.charAt(i);
//            if (Character.isDigit(ch)) {
//                double val = 0.0;
//                do {
//                    val = val * 10 + Character.getNumericValue(ch);
//                    i = i + 1;
//                    ch = exp.charAt(i);
//                } while (Character.isDigit(ch));
//
//                vals.push(val);
//            } else if (ch == '+') {
//                vals.push(vals.pop() + vals.pop());
//            }
//
//
//
//        }
//
//    }

    /**
     * Insert left parentheses for a standard expression with out left parenthesis
     * i/p: 1+21)*3-4)*567-6)))
     * o/p: ((1+21)*((3-4)*(567-6)))
     *
     * Solutions: Two stacks (a) Expression stack (b) Operator stack
     * @param exp
     * @return
     */
    public String insertLeftParentheses(String exp) {

        Stack<String> expStack = new Stack<String>();
        Stack<String> ops = new Stack<String>();

        int i = 0;
        while( i < exp.length()) {

            char ch = exp.charAt(i);

            if (ch == '+') ops.push("+");
            else if (ch == '*') ops.push("*");
            else if (ch == '-') ops.push("-");
            else if (ch == '/') ops.push("/");
            else if (Character.isDigit(ch)) {

                String e = "";
                do {
                    e = e + ch;
                    i = i + 1;
                    ch = exp.charAt(i);
                } while (Character.isDigit(ch));

                expStack.push(e);

                i = i - 1;

            } else if (ch == ')') {
                String e = expStack.pop();
                String t = "(" + expStack.pop() + ops.pop() + e + ")";
                expStack.push(t);
            }

            i += 1;
        }

        return expStack.pop();
    }

    /**
     * Random shuffle array
     * Solution: swap a[0] with a[rand(1...n)]
     *
     * @param a
     */
    public void randomShuffle(int[] a) {

        Random rand = new Random();

        for (int i = 1 ; i < a.length ; i++) {

            int j = 1 + rand.nextInt(a.length-1);

            //swap a[i] & a[j]
            int t = a[0];
            a[0] = a[j];
            a[j] = t;
        }
    }
}
