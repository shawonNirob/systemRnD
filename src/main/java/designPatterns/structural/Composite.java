package designPatterns.structural;

import java.util.ArrayList;

//Component Interface
interface CarPart {
    void display();
}

//Leaf Component: Engine
class EngineLeaf implements CarPart {
    private String type;
    private int horsePower;

    public EngineLeaf(String type, int horsePower) {
        this.type = type;
        this.horsePower = horsePower;
    }

    @Override
    public void display() {
        System.out.println("Engine type: " + type + ", Horse power: " + horsePower);
    }
}

//Leaf Component: FuelTank
class FuelTank implements CarPart {
    private String fuelType;
    private String fuelCapacity;

    public FuelTank(String fuelType, String fuelCapacity) {
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void display() {
        System.out.println("Fuel type: " + fuelType + ", Fuel capacity: " + fuelCapacity);
    }
}

//Leaf Component: Wheels
class WheelsLeaf implements CarPart {
    private int size;

    public WheelsLeaf(int size) {
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Wheels size: " + size);
    }
}

//Leaf Component: Doors
class DoorLeaf implements CarPart {
    private int numberOfDoors;

    public DoorLeaf(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void display() {
        System.out.println("Doors: " + numberOfDoors);
    }
}

//Leaf Component: Seats
class SeatLeaf implements CarPart {
    private int seatNumbers;

    public SeatLeaf(int seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    @Override
    public void display() {
        System.out.println("Seat numbers: " + seatNumbers);
    }
}

//Composite Component: Car Body (Wheels, Doors)
class CarBody implements CarPart {
    ArrayList<CarPart> carParts = new ArrayList<>();

    public void addCarBodyPart(CarPart carPart) {
        carParts.add(carPart);
    }

    @Override
    public void display() {
        System.out.println("Car Body: ");
        for (CarPart carPart : carParts) {
            carPart.display();
        }
    }
}

//Composite Component: Car Interior (Seats)
class CarInterior implements CarPart {
    private ArrayList<CarPart> carParts = new ArrayList<>();

    public void addCarInteriorPart(CarPart carPart) {
        carParts.add(carPart);
    }

    @Override
    public void display() {
        System.out.println("Car Interior: ");
        for (CarPart carPart : carParts) {
            carPart.display();
        }
    }
}

//Top-level Component: Car (Contains Car Body, Car Interior, Engine, and other parts)
class CarComposite implements CarPart {
    private String model;
    private ArrayList<CarPart> carParts = new ArrayList<>();

    public CarComposite(String model) {
        this.model = model;
    }

    // Add parts to the car
    public void addParts(CarPart carPart) {
        carParts.add(carPart);
    }

    @Override
    public void display() {
        System.out.println("Car Model: " + model);
        for (CarPart carPart : carParts) {
            carPart.display();
        }
    }
}

public class Composite {
    public static void main(String[] args) {
        // Create individual parts (Leaf Components)
        EngineLeaf engine = new EngineLeaf("L411", 907);
        FuelTank fuelTank = new FuelTank("Gasoline", "4.0L");
        WheelsLeaf wheels = new WheelsLeaf(4);
        DoorLeaf door = new DoorLeaf(2);
        SeatLeaf seat = new SeatLeaf(2);

        // Create composite components (Car Body, Car Interior)
        CarBody carBody = new CarBody();
        carBody.addCarBodyPart(wheels);
        carBody.addCarBodyPart(door);

        CarInterior carInterior = new CarInterior();
        carInterior.addCarInteriorPart(seat);

        // Create Car (Top-level Composite) and other parts
        CarComposite carComposite = new CarComposite("Lamborghini Temerio");
        carComposite.addParts(fuelTank);
        carComposite.addParts(engine);
        carComposite.addParts(carBody);
        carComposite.addParts(carInterior);

        // Display the complete car details
        carComposite.display();
    }
}