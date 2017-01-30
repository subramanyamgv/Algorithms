package com.algo.adt;

import java.util.Iterator;

/**
 * Created by Subramanyam on 30-Jan-2017.
 */
public class Stack<T> implements Iterable<T> {

    private StackNode<T> root;
    private int size;

    public interface StackListener<E> {
        public void updated(Stack<E> stack);
    }

    public class StackNode<T> {

        T data;
        StackNode<T> next;

        public StackNode(T data, StackNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Push data onto stack
     * @param data
     */
    public void push(T data) {
        root = new StackNode<T>(data, root);
        size += 1;
    }

    /**
     * Remove the item from top and return
     * @return
     */
    public T pop() {

        if (root == null)
            return null;

        T data = root.data;
        root = root.next;
        size--;
        return data;
    }

    /**
     * Return the item from top
     * @return
     */
    public T peek() {

        if (root == null)
            return null;

        return root.data;
    }

    /**
     * Return stack size
     * @return
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            StackNode<T> temp = root;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }
}
