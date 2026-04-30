package javaThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        // This is our "Metal Shelf". It can only hold 5 burgers at a time.
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        // Create 1 Producer (Chef) and 1 Consumer (Waiter)
        Thread chef = new Thread(new Producer(queue));
        Thread waiter = new Thread(new Consumer(queue));

        chef.start();
        waiter.start();
    }
}

// THE PRODUCER (Generates Data)
class Producer implements Runnable {
    private final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int burgerCount = 1;
            while (true) {
                String burger = "Burger #" + burgerCount++;
                System.out.println("Chef cooked: " + burger);

                // .put() will add the item.
                // IF THE QUEUE IS FULL, the Chef thread automatically pauses here!
                queue.put(burger);

                Thread.sleep(500); // Cooking takes 0.5 seconds
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// THE CONSUMER (Processes Data)
class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // .take() will fetch an item.
                // IF THE QUEUE IS EMPTY, the Waiter thread automatically pauses here!
                String burger = queue.take();

                System.out.println("Waiter served: " + burger);
                Thread.sleep(4000); // Serving takes 2 seconds (slower than cooking)
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
