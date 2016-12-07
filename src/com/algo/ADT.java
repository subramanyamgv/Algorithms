package com.algo;

import java.util.Iterator;

/**
 * Created by Subramanyam on 29-Nov-2016.
 */
public class ADT {

    public static class Stack<E> implements Iterable<E> {

        public interface StackListener<E> {
            public void updated(Stack<E> stack);
        }

        private LinkedList<E> list;
        private int count = 0;

        public Stack() {
            list = new LinkedList<E>();
        }

        public void push(E data) {
            count ++;
            list.insertFirst(data);
        }

        public E pop() {
            E e = list.removeFirst();

            if (e != null)
                count --;

            return e;
        }

        public E peek() {
            return list.get(0);
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public int getCount() {
            return count;
        }

        @Override
        public Iterator<E> iterator() {
            return list.getIterator();
        }

        public Iterator<E> getIterator() {
            return list.getIterator();
        }
    }


    public static class Queue<E> {

        LinkedList<E> list;
        private int count = 0;

        public Queue() {
            this.list = new LinkedList<E>();
        }

        public void offer(E data) {
            count ++;
            list.insertEnd(data);
        }

        public E poll() {
            E e = list.removeFirst();

            if (e != null)
                count --;

            return e;
        }

        public E peek() {
            return list.get(0);
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public int getCount() {
            return count;
        }

        public Iterator<E> getIterator() {
            return list.getIterator();
        }
    }
}
