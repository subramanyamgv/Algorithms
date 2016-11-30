package com.algo;

/**
 * Created by Subramanyam on 29-Nov-2016.
 */
public class ADT {

    public static class Stack<E> {

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


    public static class Queue<E> {

        LinkedList<E> list;

        public Queue() {
            this.list = new LinkedList<E>();
        }

        public void put(E data) {
            list.insertEnd(data);
        }

        public E get() {
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
