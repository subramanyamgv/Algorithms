package com.algo;

/**
 * Created by Subramanyam on 29-Nov-2016.
 */
public class ADT {

    public static class Stack<E> {

        private int count;
        private LinkedList<E> list;

        public Stack() {
            list = new LinkedList<E>();
        }

        public void push(E data) {
            list.insertFirst(data);
        }

        public E pop() {
            return list.removeFirst();
        }

        public E peek() {
            return list.get(0);
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }
}
