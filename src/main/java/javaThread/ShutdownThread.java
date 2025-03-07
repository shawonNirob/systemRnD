package javaThread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

class WatchShutDown implements Runnable {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public boolean running = true;

    @Override
    public void run() {
        while (running) {
            printCurrentTime();
            sleepOneSecond();

            if(!running){
                System.out.println("Thread is Shutdown");
                return;
            }
        }
    }

    public void shutdown(){
        this.running = false;
    }

    public void printCurrentTime(){
        String formattedCurrentTime = LocalDateTime.now().format(formatter);
        System.out.println(formattedCurrentTime);
    }

    private void sleepOneSecond() {
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }catch (InterruptedException ignored){
            //No need the interrupt the thread, while we use running
            //Thread.currentThread().interrupt();
        }
    }
}

public class ShutdownThread{
    public static void main(String[] args) throws InterruptedException {
        WatchShutDown watchShutDown = new WatchShutDown();
        Thread thread = new Thread(watchShutDown);
        thread.start();

        Thread.sleep(5000);
        watchShutDown.shutdown();
    }
}
