package com.algo;


import static com.algo.ADT.*;

/**
     * Synchronized BoundedQueue
     * @param <T>
     */
public class BoundingQueue<T> {

    private int size;
    private Queue<T> buffer;

    public BoundingQueue(int size) {
        this.size = size;
        this.buffer = new Queue<T>();
    }

    public synchronized T get() throws InterruptedException {

        while (buffer.isEmpty()) {
            wait();
        }

        T data = buffer.poll();
        notify();
        return data;
    }

    public synchronized void put(T data) throws InterruptedException  {

        if (buffer.getCount() == size)
            wait();

        buffer.offer(data);
        notify();
    }
}
