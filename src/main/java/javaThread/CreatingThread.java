package javaThread;

public class CreatingThread extends Thread {
    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("Thread Name: " + currentThreadName);
    }
}
class main{
    public static void main(String[] args) {
        CreatingThread creatingThread = new CreatingThread();
        creatingThread.start();
    }
}
