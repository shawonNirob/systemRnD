package advancedLLMs;

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
    void wagTail(){
        System.out.println("Wag Tail");
    }
}

public class Casting {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Upcasting
        myDog.sound();// Output: Dog barks (due to method overriding)
        ((Dog) myDog).wagTail();
    }
}
