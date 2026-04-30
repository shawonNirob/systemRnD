package javaThread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyDemo {

    private static final int THREAD_COUNT = 100;
    private static final int OPERATIONS_PER_THREAD = 10000;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting Benchmark...\n");

        // 1. THE OLD WAY (Synchronized Collection)
        // Coarse-Grained Lock: Only ONE thread can touch this map at a time.
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        long syncTime = runBenchmark(syncMap, "SynchronizedMap");

        // 2. THE MODERN WAY (Concurrent Collection)
        // Fine-Grained Lock: Multiple threads can touch different parts
        // of this map at the exact same time.
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        long concurrentTime = runBenchmark(concurrentMap, "ConcurrentHashMap");

        // Print Results
        System.out.println("\n--- FINAL RESULTS ---");
        System.out.println("SynchronizedMap took: " + syncTime + " ms (The Traffic Jam)");
        System.out.println("ConcurrentHashMap took: " + concurrentTime + " ms (The Highway)");
    }

    /**
     * This method floods the given Map with thousands of concurrent read/write requests.
     */
    private static long runBenchmark(Map<String, Integer> sharedMap, String mapName) throws InterruptedException {
        // Create a pool of 100 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        long startTime = System.currentTimeMillis();

        // Give all 100 threads their instructions
        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.execute(() -> {
                for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                    // Simulate a read/write operation (e.g., updating a user's wallet balance)
                    String key = "User_" + (j % 50); // 50 different users

                    // Put data in
                    sharedMap.put(key, j);

                    // Read data out
                    sharedMap.get(key);
                }
            });
        }

        // Tell the threads to start and wait for them all to finish
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long endTime = System.currentTimeMillis();
        System.out.println(mapName + " finished processing 1,000,000 operations.");

        return (endTime - startTime);
    }
}
