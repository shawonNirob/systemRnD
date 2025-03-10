package javaThread;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class FibonacciTask implements Runnable {
    private long n;
    private String id;
    public FibonacciTask(long n, String id) {
        this.n = n;
        this.id = id;
    }

    private BigDecimal fib(long n){
        if(n==0){
            return BigDecimal.ZERO;
        } else if (n==1) {
            return BigDecimal.ONE;
        }else {
            return fib(n-1).add(fib(n-2));
        }
    }

    @Override
    public void run() {
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE_TIME;

        System.out.println("Fibonacci task started " + id + " at " + isoFormatter.format(LocalDateTime.now()));

        BigDecimal fib = fib(n);

        System.out.println("Ending fibonacci task at " + id + " at " + isoFormatter.format(LocalDateTime.now()));
    }
}


public class ThreadSchedule {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new FibonacciTask(45, "Fibonacci Task 1"));
        Thread t2 = new Thread(new FibonacciTask(45, "Fibonacci Task 2"));
        Thread t3 = new Thread(new FibonacciTask(45, "Fibonacci Task 3"));
        Thread t4 = new Thread(new FibonacciTask(45, "Fibonacci Task 4"));
        Thread t5 = new Thread(new FibonacciTask(45, "Fibonacci Task 5"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
