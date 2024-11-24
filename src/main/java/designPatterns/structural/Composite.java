package designPatterns.structural;

import java.util.ArrayList;
import java.util.List;

// Component Interface
interface CarPart {
    void display();  // Display method to be implemented by both Leaf and Composite components
}

// Leaf Component: Engine
class Engine implements CarPart {
    private String type;
    private int horsePower;

    public Engine(String type, int horsePower) {
        this.type = type;
        this.horsePower = horsePower;
    }

    @Override
    public void display() {
        System.out.println("Engine Type: " + type + ", HorsePower: " + horsePower);
    }
}

// Leaf Component: Wheels
class Wheels implements CarPart {
    private int size;

    public Wheels(int size) {
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Wheels Size: " + size + " inches");
    }
}

// Leaf Component: Doors
class Doors implements CarPart {
    private int numberOfDoors;

    public Doors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void display() {
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

// Composite Component: Car Body (Contains other CarParts)
class CarBody implements CarPart {
    private List<CarPart> carParts = new ArrayList<>();

    public void addPart(CarPart part) {
        carParts.add(part);
    }

    @Override
    public void display() {
        System.out.println("Car Body: ");
        for (CarPart part : carParts) {
            part.display();  // Delegate the responsibility to parts (either leaf or composite)
        }
    }
}

// Composite Component: Car Interior (Contains other CarParts)
class CarInterior implements CarPart {
    private List<CarPart> carParts = new ArrayList<>();

    public void addPart(CarPart part) {
        carParts.add(part);
    }

    @Override
    public void display() {
        System.out.println("Car Interior: ");
        for (CarPart part : carParts) {
            part.display();  // Delegate the responsibility to parts (either leaf or composite)
        }
    }
}

// Composite Component: Car (Contains Car Body, Car Interior, and other parts)
class Car implements CarPart {
    private String model;
    private CarBody carBody;
    private CarInterior carInterior;

    public Car(String model) {
        this.model = model;
        this.carBody = new CarBody();
        this.carInterior = new CarInterior();
    }

    public void addCarBodyPart(CarPart part) {
        carBody.addPart(part);
    }

    public void addCarInteriorPart(CarPart part) {
        carInterior.addPart(part);
    }

    @Override
    public void display() {
        System.out.println("Car Model: " + model);
        carBody.display();  // Display the Car Body
        carInterior.display();  // Display the Car Interior
    }
}

// Client Code
public class Composite {
    public static void main(String[] args) {
        // Create individual parts (Leaf Components)
        Engine engine = new Engine("V8", 500);
        Wheels wheels = new Wheels(18);
        Doors doors = new Doors(4);

        // Create composite components (CarBody, CarInterior)
        CarBody carBody = new CarBody();
        carBody.addPart(engine);
        carBody.addPart(wheels);
        carBody.addPart(doors);

        CarInterior carInterior = new CarInterior();
        carInterior.addPart(new Wheels(16));  // Another set of wheels in the interior for simulation

        // Create Car (Composite) and add body and interior parts
        Car car = new Car("SportsCar");
        car.addCarBodyPart(engine);
        car.addCarBodyPart(wheels);
        car.addCarBodyPart(doors);
        car.addCarInteriorPart(carInterior);

        // Display the entire car system
        car.display();
    }
}
