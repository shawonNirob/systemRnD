package designPatterns.creational;

class EagerSingleton {
    // Create an instance of the class at the time of class loading
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent instantiation
    private EagerSingleton() {}

    // Public method to provide access to the instance
    public static EagerSingleton getInstance() {
        return instance;
    }
    public void showMessage() {
        System.out.println("Hello, I am a EagerSingleton instance!");
    }
}

class LazySingleton {
    // The instance is declared but not initialized
    private static LazySingleton instance;

    // Private constructor to prevent instantiation
    private LazySingleton() {}

    // Synchronized method to control simultaneous access
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton(); // Create instance if it doesn't exist
        }
        return instance;
    }
    public void showMessage() {
        System.out.println("Hello, I am a LazySingleton instance!");
    }
}

class BillPughSingleton {
    // Private constructor to prevent instantiation
    private BillPughSingleton() {}

    // Static inner class responsible for holding the singleton instance
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Public method to provide access to the instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello, I am a BillPughSingleton instance!");
    }
}

public class SingletonMain {
    public static void main(String[] args) {
        EagerSingleton eagerInstance = EagerSingleton.getInstance();
        LazySingleton lazyInstance = LazySingleton.getInstance();
        BillPughSingleton billPughInstance = BillPughSingleton.getInstance();

        eagerInstance.showMessage();
        lazyInstance.showMessage();
        billPughInstance.showMessage();

        // Verify that all instances are the same
        System.out.println(eagerInstance.equals(lazyInstance)); // Output: false (different implementations)
        System.out.println(lazyInstance.equals(billPughInstance));
        System.out.println(billPughInstance.equals(eagerInstance));// Output: false (different implementations)
    }
}
