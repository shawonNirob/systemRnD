package javaThread;

import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {

        // 1. Create the Bank: A Thread Pool with exactly 3 permanent workers
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            // 2. Define a Callable task (A task that returns a String)
            Callable<String> fetchUserTask = () -> {
                Thread.sleep(2000); // Simulate slow DB query (2 seconds)
                return "User Data from DB";
            };

            System.out.println("Submitting tasks to the Executor...");

            // 3. Submit the tasks. We immediately get "buzzers" (Futures) back.
            Future<String> buzzer1 = executor.submit(fetchUserTask);
            Future<String> buzzer2 = executor.submit(fetchUserTask);
            Future<String> buzzer3 = executor.submit(fetchUserTask);

            // 4. Do other work while the threads are busy!
            System.out.println("Tasks are running in the background. Doing other work now...");

            // 5. Retrieve the results.
            // .get() will block only if the task isn't finished yet.
            String result1 = buzzer1.get();
            String result2 = buzzer2.get();
            String result3 = buzzer3.get();

            System.out.println("Got results: " + result1 + ", " + result2 + ", " + result3);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 6. Always shut down the executor, otherwise the JVM will never exit!
            executor.shutdown();
        }
    }
}
