package com.algo.adt;

import java.util.Iterator;

/**
 * Created by Subramanyam on 30-Jan-2017.
 */
public class Queue<T> implements Iterable<T> {

    private QueueNode<T> head, tail;
    private int size;

    public class QueueNode<T> {
        T data;
        QueueNode<T> next;

        public QueueNode(T data, QueueNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Insert the data at the end of the queue
     * @param data
     */
    public void offer(T data) {

        QueueNode<T> temp = new QueueNode<T>(data, null);

        if (head == null) { //Tail will also be null at this point
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = tail.next;
        }
        size += 1;
    }

    /**
     * Remove the data at the start of the queue, and return
     * @return
     */
    public T poll() {

        if (head == null)
            return null;

        T data = head.data;
        head = head.next;
        size --;

        if (head == null)
            tail = null;

        return data;
    }

    /**
     * Return the item at front of the queue
     * @return
     */
    public T peek() {

        if (head == null) {
            return null;
        }

        return head.data;
    }

    /**
     * returns queue size
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if queue is empty, otherwise false
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            QueueNode<T> temp = head;

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
