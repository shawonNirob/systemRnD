package designPatterns.structural;

// The Engine interface (Implementor)
interface Engine {
    void startEngine();
    void stopEngine();
    void displayEngineType();
}

// Concrete Implementor 1: V8 Engine
class V8Engine implements Engine {

    @Override
    public void startEngine() {
        System.out.println("Starting V8 engine...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping V8 engine...");
    }

    @Override
    public void displayEngineType() {
        System.out.println("This is a V8 Engine.");
    }
}

// Concrete Implementor 2: Electric Engine
class ElectricEngine implements Engine {

    @Override
    public void startEngine() {
        System.out.println("Starting electric engine...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping electric engine...");
    }

    @Override
    public void displayEngineType() {
        System.out.println("This is an Electric Engine.");
    }
}

// The Car class (Abstraction)
abstract class Car {
    protected Engine engine; // The bridge between abstraction and implementation.

    public Car(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();
    public abstract void stop();
}

// Refined Abstraction 1: SportsCar
class SportsCar extends Car {

    public SportsCar(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        System.out.println("Driving the sports car...");
        engine.startEngine();
    }

    @Override
    public void stop() {
        System.out.println("Sports car stopping...");
        engine.stopEngine();
    }
}

// Refined Abstraction 2: FamilyCar
class FamilyCar extends Car {

    public FamilyCar(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        System.out.println("Driving the family car...");
        engine.startEngine();
    }

    @Override
    public void stop() {
        System.out.println("Family car stopping...");
        engine.stopEngine();
    }
}

// Main class to test the Bridge Pattern
public class Bridge {
    public static void main(String[] args) {
        // Create different engine types
        Engine v8Engine = new V8Engine();
        Engine electricEngine = new ElectricEngine();

        // Create different car types using these engines
        Car sportsCarWithV8 = new SportsCar(v8Engine);
        Car familyCarWithElectric = new FamilyCar(electricEngine);

        // Test different combinations
        System.out.println("Testing Sports Car with V8 Engine:");
        sportsCarWithV8.drive();
        sportsCarWithV8.stop();
        System.out.println();

        System.out.println("Testing Family Car with Electric Engine:");
        familyCarWithElectric.drive();
        familyCarWithElectric.stop();
    }
}
