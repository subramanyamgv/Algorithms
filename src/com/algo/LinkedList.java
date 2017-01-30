package com.algo;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Subramanyam on 23-Nov-2016.
 */
public class LinkedList<E> implements Iterable<E> {

    private static class LinkedListNode<E> {
        E data;
        LinkedListNode<E> next;

        public LinkedListNode(E data, LinkedListNode<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    LinkedListNode<E> head, tail;
    int size;
    private Iterator<E> iterator;

    public void init(E[] items) {

        clear();

        for (E item : items) {
            add(item);
        }
    }

    public Iterator<E> getIterator() {
        return new LinkedListIterator<E>(head);
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(head);
    }

    public void add(E data) {

        LinkedListNode<E> temp = new LinkedListNode<E>(data, null);

        if (head == null) { //List empty
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = tail.next;
        }
    }

    public void insertFirst(E data) {
        LinkedListNode<E> temp = new LinkedListNode<E>(data, null);
        temp.next = head;
        head = temp;
    }

    public void insertEnd(E data) {

        LinkedListNode<E> temp = new LinkedListNode<E>(data, null);

        if (head == null) { //List empty
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = tail.next;
        }

    }

    public E removeFirst() {

        if (head == null)
            return null;

        LinkedListNode<E> temp = head;
        head = head.next;

        if (head == null)
            tail = null;

        return temp.data;
    }

    public void add(E data, int pos) {
        //TODO:
    }

    public void delete(int pos) {
        //TODO:
    }

    public int size() {
        LinkedListNode<E> temp = head;
        while (temp != null) {
            temp = temp.next;
            size += 1;
        }
        return size;
    }

    public E get(int i) {

        LinkedListNode<E> temp = head;

        while (i-- > 0 && temp.next != null) {
            temp = temp.next;
        }

        return temp.data;
    }

    public E getMiddle() {

        LinkedListNode<E> slow = head;
        LinkedListNode<E> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    /**
     * Reverse linked list
     */
    public void reverse() {

        LinkedListNode<E> p, q;
        p = q = null;
        tail = head;

        while (head != null) {
            p = head.next;
            head.next = q;
            q = head;
            head = p;
        }

        head = q;
    }

    public void clear() {
        head = tail = null;
    }

    /**
     * Merge two linked lists
     */
    public void merge(LinkedList<E> list, Comparator comparator) {

        LinkedListNode<E> c = new LinkedListNode<E>(null, null);
        LinkedListNode<E> dummy = c;

        while (head != null && list.head != null) {

            if (comparator.compare(head.data, list.head.data) <= 0) {
                c.next = head; c = head;
                head = head.next;
            } else {
                c.next = list.head; c = list.head;
                list.head = list.head.next;
            }
        }

        c.next = (head == null) ? list.head : head;

        head = dummy.next;
    }

    public LinkedListNode<Integer> sum(LinkedList<Integer> L1, LinkedList<Integer> L2) {

        LinkedListNode<Integer> c = new LinkedListNode<Integer>(null, null);
        LinkedListNode<Integer> dummy = c;

        LinkedListNode<Integer> L1temp = L1.head;
        LinkedListNode<Integer> L2temp = L2.head;

        while (L1temp != null || L2temp != null) {
            Integer data = ((L1temp != null ? L1temp.data : 0) + (L2temp != null ? L2temp.data : 0));
            c.next = new LinkedListNode<Integer>(data, null);
            c = c.next;
        }

        return dummy.next;
    }

    /**
     * Get Nth node from last
     */
    public E getFromLast(int n) throws Exception {

        if (head == null) {
            throw new IllegalArgumentException("List empty");
        }

        LinkedListNode<E> p, q;
        p = q = head;

        while (n-- > 0 && q != null) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        return p.data;
    }

    public class LinkedListIterator<E> implements Iterator<E> {

        LinkedListNode<E> temp;

        public LinkedListIterator(LinkedListNode<E> head) {
            this.temp = head;
        }

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public E next() {
            E data = temp.data;
            temp = temp.next;
            return data;
        }
    }




}
