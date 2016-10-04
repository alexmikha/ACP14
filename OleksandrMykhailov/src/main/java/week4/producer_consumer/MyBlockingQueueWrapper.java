package week4.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by serhii on 19.06.16.
 */
public class MyBlockingQueueWrapper {

    private BlockingQueue blockingQueue;

    public MyBlockingQueueWrapper(int capacity) {
        blockingQueue = new ArrayBlockingQueue(capacity);
    }

    public void add(Object el) {
        try {
            blockingQueue.put(el);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Object remove() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getSize() {
        return blockingQueue.size();
    }

}
