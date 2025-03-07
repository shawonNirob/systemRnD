package javaThread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

class watch implements Runnable{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            PrintCurrentDateTime();
            sleepOneSecond();

            if(Thread.interrupted()){
                System.out.println("Thread is interrupted");
                return;
            }

        }
    }

    private void sleepOneSecond(){
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void PrintCurrentDateTime(){
        String formattedCurrentTime = LocalDateTime.now().format(formatter);

        System.out.println(formattedCurrentTime);
    }
}

public class TerminatingThread{
    public static void main(String[] args) throws InterruptedException {
        watch watch = new watch();
        Thread watchThread = new Thread(watch);
        watchThread.start();

        Thread.sleep(1000);
        watchThread.interrupt();
    }
}

/*
The code you've shared implements a simple clock application using Java threads. Let me explain the main function and the overall workflow:

### Main Function Explanation

In the `TerminatingThread` class's main method:

1. A new `watch` object is created, which implements the `Runnable` interface
2. This `watch` object is passed to a new `Thread` called `watchThread`
3. The thread is started using `watchThread.start()`
4. The main thread sleeps for 1 second (1000 milliseconds)
5. After 1 second, the main thread interrupts the watch thread using `watchThread.interrupt()`

1. **Thread Creation and Startup**:
   - The main thread creates a `watch` object that implements the `Runnable` interface
   - A new thread (`watchThread`) is created with this `watch` object
   - The thread is started, which calls the `run()` method of the `watch` object

2. **Watch Thread Execution**:
   - The `run()` method contains an infinite loop that continues until the thread is interrupted
   - In each iteration, it:
     - Displays the current time using `PrintCurrentDateTime()`
     - Sleeps for one second using `sleepOneSecond()`
     - Checks if the thread has been interrupted

3. **Interruption Handling**:
   - The main thread sleeps for 1 second, then interrupts the watch thread
   - When the watch thread is sleeping, the interrupt causes an `InterruptedException`
   - The exception is caught in the `sleepOneSecond()` method, which re-interrupts the thread
   - After waking up, the thread checks if it's been interrupted using `Thread.interrupted()`
   - When it detects the interruption, it prints a message and exits the run method

4. **Thread Termination**:
   - The watch thread terminates when it exits the `run()` method
   - The main thread continues execution after calling `interrupt()`

This implementation demonstrates a clean way to handle thread interruption in Java, ensuring that the thread responds to interruption signals even when it's sleeping.
 */
