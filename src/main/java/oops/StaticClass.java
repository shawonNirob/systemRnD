package oops;

class Counter {
    int count = 0; // static variable

    Counter() {
        count++; // shared among all instances
    }
}

public class StaticClass {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        System.out.println(c2.count); // Output: 2 (shared across all instances)
    }
}
