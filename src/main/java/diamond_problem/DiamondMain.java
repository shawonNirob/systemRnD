package diamond_problem;

interface A {
    default void display() {
        System.out.println("A's display");
    }
}

interface B {
    default void display() {
        System.out.println("B's display");
    }
}

class D implements A, B {
    @Override
    public void display() {
        // Must resolve the conflict between A and B
        B.super.display();  // Explicitly call A's default method
    }
}

public class DiamondMain {
    public static void main(String[] args) {
        D obj = new D();
        obj.display();  // Calls A's display method
    }
}
