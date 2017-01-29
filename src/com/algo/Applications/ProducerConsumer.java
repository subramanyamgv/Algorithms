package com.algo.applications;

import com.algo.BoundingQueue;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by Subramanyam on 29-Jan-2017.
 */
public class ProducerConsumer {

    public void start(int noOfConsumers) {

        BoundingQueue<Integer> queue = new BoundingQueue<Integer>(10);

        Producer producer = new Producer(queue);
        List<Consumer> consumers = new LinkedList<Consumer>();
        for (int i = 1 ; i <= noOfConsumers ; i++) {
            consumers.add(new Consumer(queue, i));
        }

        //Start producer and Consumer
        producer.start();
        for (Consumer consumer : consumers) {
            consumer.start();
        }

        try {
            producer.join();
            for (Consumer consumer : consumers) {
                consumer.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Producer extends Thread {

        BoundingQueue<Integer> queue;

        public Producer(BoundingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

            for (int i = 0 ; i < 100 ; i++) {
                try {
                    System.out.println("Produced : " + i);
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread {

        BoundingQueue<Integer> queue;
        int index;

        public Consumer(BoundingQueue<Integer> queue, int index) {
            this.queue = queue;
            this.index = index;
        }

        @Override
        public void run() {
            for (int i = 0 ; i < 100 ; i++) {
                try {
                    System.out.println("Consumed" + index + " : " + queue.get());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
