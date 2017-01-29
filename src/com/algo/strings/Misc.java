package com.algo.strings;

import java.util.Stack;

/**
 * Created by Subramanyam on 21-Dec-2016.
 */
public class Misc {

    /**
     * Compress the string aaabccccccddd to a2b1c6d3
     * @param str
     * @return
     */
    public String compress(String str) {

        int n = str.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < n ; i++) {

            count++;

            if (i+1 >= n || (str.charAt(i) != str.charAt(i+1))) {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;
            }
        }

        return sb.length() < str.length() ? sb.toString() : str;
    }

    public String reduce(String str) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0 ; i < str.length() ; i++) {

            if (stack.isEmpty() || (stack.peek() != str.charAt(i))) {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

}
