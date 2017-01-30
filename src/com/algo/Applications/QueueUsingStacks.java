package com.algo.applications;

import com.algo.adt.*;

/**
 * Created by Subramanyam on 07-Dec-2016.
 */
public class QueueUsingStacks<E> {

    Stack<E> S1, S2;

    public QueueUsingStacks() {
        S1 = new Stack<E>();
        S2 = new Stack<E>();
    }

    public void offer(E data) {
        S1.push(data);
    }

    public E poll() {

        //If S2 is empty, transfer all S1 elements into S2;
        if (S2.isEmpty()) {
            while (!S1.isEmpty()) {
                S2.push(S1.pop());
            }
        }

        return S2.pop();
    }

    public E peek() {

        //If S2 is empty, transfer all S1 elements into S2;
        if (S2.isEmpty()) {
            while (!S1.isEmpty()) {
                S2.push(S1.pop());
            }
        }

        return S2.peek();    }

    public boolean isEmpty() {
        return S1.isEmpty() && S2.isEmpty();
    }

    public int count() {
        return S1.size() + S2.size();
    }
}
