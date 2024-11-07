package oops;

public class ExceptionPropagation{

    public static void main(String[] args) {
        try {
            methodA();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in main: " + e);
        }
    }

    static void methodA() {
        methodB();
    }

    static void methodB() {
        methodC();
    }

    static void methodC() {
        int result = 10 / 0; // This will throw an ArithmeticException
    }
}

