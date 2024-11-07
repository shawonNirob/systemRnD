package oops;

class Engine{
    public void start(){
        System.out.println("Engine is Start");
    }
}

class Car{
    public Engine engine; // The Car "has a" Engine

    public Car(){
        engine = new Engine(); // Car contains a engine object
    }
    public void start(){
        engine.start(); // Calling the method of engine object
        System.out.println("Car is running at 10 mile/hour");
    }
}

public class Composition {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
    }
}
