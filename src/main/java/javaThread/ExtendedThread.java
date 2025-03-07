package javaThread;

import java.util.concurrent.TimeUnit;

public class ExtendedThread extends Thread {
    @Override
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println("[" + i + "] Inside " + Thread.currentThread().getName());
            sleepOneSecound();
        }
    }

    private static void sleepOneSecound(){
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        ExtendedThread extendedThread = new ExtendedThread();
        extendedThread.setName("Extended Thread");
        extendedThread.start();

        for(int i=0; i<5; i++){
            System.out.println("[" + i + "] Inside " + Thread.currentThread().getName());
            sleepOneSecound();
        }
    }

    private static void sleepOneSecound(){
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
