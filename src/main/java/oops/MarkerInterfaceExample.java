package oops;

// Marker interface
interface SpecialFeature {}

// Class that implements the marker interface
class MyClass implements SpecialFeature {
    // Class implementation
}

public class MarkerInterfaceExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        // Check if obj is an instance of SpecialFeature
        if (obj instanceof SpecialFeature) {
            System.out.println("MyClass has a special feature!");
        } else {
            System.out.println("MyClass does not have a special feature.");
        }
    }
}
