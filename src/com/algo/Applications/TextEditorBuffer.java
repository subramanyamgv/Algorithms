package com.algo.Applications;

import static com.algo.ADT.*;

/**
 * A text editor data buffer management
 *
 * Created by Subramanyam on 07-Dec-2016.
 */
public class TextEditorBuffer {

    Stack<Character> lStack, rStack;

    /**
     * Creates an empty buffer
     */
    public TextEditorBuffer() {
        lStack = new Stack<Character>();
        rStack = new Stack<Character>();
    }

    /**
     * Insert c at the cursor position
     * @param c
     */
    public void insert(char c) {
        lStack.push(c);
    }

    /**
     * Return character at a given position
     * @return
     */
    public char get() {
        return lStack.peek();
    }

    /**
     * delete character at a given position
     * @return
     */
    public char delete() {
        return lStack.pop();
    }

    /**
     * Move cursor k positions left
     * For each cursor movement, pop from left stack and push onto new stack
     * @param k
     */
    public void left(int k) {

        while (k != 0 && k < lStack.getCount()) {
            rStack.push(lStack.pop());
            k--;
        }
    }

    /**
     * Move cursor k positions right
     * For each cursor movement, pop from right stack and push onto left stack
     * @param k
     */
    public void right(int k) {

        while (k != 0 && k < rStack.getCount()) {
            lStack.push(rStack.pop());
            k--;
        }
    }

    /**
     * Return size of buffer;
     * @return
     */
    public int size() {
        return lStack.getCount() + rStack.getCount();
    }
}