package designPatterns.structural;

// Traditional Car Engine Interface (Target)
interface Engine {
    void startEngine();
    void stopEngine();
    void accelerate();
    void brake();
    String getEngineType();
}

// Traditional Petrol Engine (Concrete Implementation)
class PetrolEngine implements Engine {
    private boolean isRunning;
    private int speed;

    @Override
    public void startEngine() {
        isRunning = true;
        System.out.println("Petrol Engine: Starting with ignition and fuel injection");
    }

    @Override
    public void stopEngine() {
        isRunning = false;
        speed = 0;
        System.out.println("Petrol Engine: Stopping engine, cutting fuel supply");
    }

    @Override
    public void accelerate() {
        if (isRunning) {
            speed += 10;
            System.out.println("Petrol Engine: Increasing fuel injection, current speed: " + speed + " km/h");
        }
    }

    @Override
    public void brake() {
        if (speed > 0) {
            speed -= 10;
            System.out.println("Petrol Engine: Reducing fuel supply, current speed: " + speed + " km/h");
        }
    }

    @Override
    public String getEngineType() {
        return "Petrol Engine";
    }
}

// Modern Electric Motor (Adaptee)
class ElectricMotor {
    private boolean motorPowered;
    private int currentSpeed;

    public void connectToPowerSource() {
        System.out.println("Electric Motor: Connecting to battery power");
    }

    public void activateMotor() {
        motorPowered = true;
        System.out.println("Electric Motor: Activating motor controllers");
    }

    public void increaseVoltage() {
        if (motorPowered) {
            currentSpeed += 15;
            System.out.println("Electric Motor: Increasing voltage, current speed: " + currentSpeed + " km/h");
        }
    }

    public void decreaseVoltage() {
        if (currentSpeed > 0) {
            currentSpeed -= 15;
            System.out.println("Electric Motor: Decreasing voltage, current speed: " + currentSpeed + " km/h");
        }
    }

    public void shutDownMotor() {
        motorPowered = false;
        currentSpeed = 0;
        System.out.println("Electric Motor: Disconnecting power and shutting down controllers");
    }
}

// Adapter for Electric Motor
class ElectricMotorAdapter implements Engine {
    private ElectricMotor electricMotor;

    public ElectricMotorAdapter(ElectricMotor electricMotor) {
        this.electricMotor = electricMotor;
    }

    @Override
    public void startEngine() {
        electricMotor.connectToPowerSource();
        electricMotor.activateMotor();
    }

    @Override
    public void stopEngine() {
        electricMotor.shutDownMotor();
    }

    @Override
    public void accelerate() {
        electricMotor.increaseVoltage();
    }

    @Override
    public void brake() {
        electricMotor.decreaseVoltage();
    }

    @Override
    public String getEngineType() {
        return "Electric Motor";
    }
}

// Car class that uses the Engine interface
class Car {
    private Engine engine;
    private String model;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void startCar() {
        System.out.println(model + " with " + engine.getEngineType() + " is starting...");
        engine.startEngine();
    }

    public void drive() {
        engine.accelerate();
        engine.accelerate(); // Accelerate twice
        engine.brake();      // Then brake
    }

    public void stopCar() {
        System.out.println(model + " is stopping...");
        engine.stopEngine();
    }
}

// Demo Class
public class Adepter{
    public static void main(String[] args) {
        // Traditional Petrol Car
        Car petrolCar = new Car("Toyota Camry", new PetrolEngine());

        // Electric Car using adapter
        ElectricMotor electricMotor = new ElectricMotor();
        Car electricCar = new Car("Tesla Model 3", new ElectricMotorAdapter(electricMotor));

        // Test both cars
        System.out.println("=== Testing Petrol Car ===");
        petrolCar.startCar();
        petrolCar.drive();
        petrolCar.stopCar();

        System.out.println("\n=== Testing Electric Car ===");
        electricCar.startCar();
        electricCar.drive();
        electricCar.stopCar();
    }
}
