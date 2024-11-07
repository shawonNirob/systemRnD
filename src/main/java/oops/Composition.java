package oops;

class Engine{
    public void start(){
        System.out.println("Engine is Start");
    }
}

class Car{
    public Engine engine;

    public Car(){
        engine = new Engine();
    }
    public void start(){
        engine.start();
        System.out.println("Car is running at 10 mile/hour");
    }
}

public class Composition {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
    }
}
