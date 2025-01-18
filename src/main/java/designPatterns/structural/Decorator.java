package designPatterns.structural;



// Component Interface (remains the same)
interface Car {
    void assemble();
}

// Concrete Component: Basic Car (remains the same)
class BasicCar implements Car {
    private Engine engine;
    public BasicCar(Engine engine) {
        this.engine = engine;ss
    }
    @Override
    public void assemble() {
        System.out.println("Basic Car Assembly");
        engine.assemble();
    }
    // Getter added to allow access to engine for decorators
    public Engine getEngine() {
        return engine;
    }
}

// New Concrete Component: Sports Car
class SportsCar implements Car {
    private Engine engine;
    private String model;

    public SportsCar(Engine engine, String model) {
        this.engine = engine;
        this.model = model;
    }

    @Override
    public void assemble() {
        System.out.println("Sports Car Assembly: " + model);
        engine.assemble();
    }

    // Getter added to allow access to engine for decorators
    public Engine getEngine() {
        return engine;
    }
}

// Concrete Component: Engine (remains the same)
class Engine {
    private String type;
    private int horsePower;
    public Engine(String type, int horsePower) {
        this.type = type;
        this.horsePower = horsePower;
    }
    public void assemble() {
        System.out.println("Engine Type: " + type + ", Horse Power: " + horsePower);
    }
    public void addHorsePower(int additionalPower) {
        this.horsePower += additionalPower;
    }
    public int getHorsePower() {
        return this.horsePower;
    }
}

// Decorator Class (modified to work with different car types)
abstract class CarDecorator implements Car {
    protected Car decoratedCar;
    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }
    public void assemble() {
        decoratedCar.assemble();
    }
}

// Concrete Decorator: Turbo (modified)
class TurboDecorator extends CarDecorator {
    public TurboDecorator(Car car) {
        super(car);
    }
    @Override
    public void assemble() {
        super.assemble();
        addTurboFeature();
    }
    private void addTurboFeature() {
        System.out.println("Adding Turbo feature");
        Engine engine = null;

        // Handle different car types
        if (decoratedCar instanceof BasicCar) {
            engine = ((BasicCar) decoratedCar).getEngine();
        } else if (decoratedCar instanceof SportsCar) {
            engine = ((SportsCar) decoratedCar).getEngine();
        }

        if (engine != null) {
            engine.addHorsePower(100); // Increase horse power by 100 due to Turbo
        }
    }
}

// Concrete Decorator: Supercharger (modified similarly)
class SuperchargerDecorator extends CarDecorator {
    public SuperchargerDecorator(Car car) {
        super(car);
    }
    @Override
    public void assemble() {
        super.assemble();
        addSuperchargerFeature();
    }
    private void addSuperchargerFeature() {
        System.out.println("Adding Supercharger feature");
        Engine engine = null;

        // Handle different car types
        if (decoratedCar instanceof BasicCar) {
            engine = ((BasicCar) decoratedCar).getEngine();
        } else if (decoratedCar instanceof SportsCar) {
            engine = ((SportsCar) decoratedCar).getEngine();
        }

        if (engine != null) {
            engine.addHorsePower(150); // Increase horse power by 150 due to Supercharger
        }
    }
}

// Concrete Decorator: Eco-Mode (modified similarly)
class EcoModeDecorator extends CarDecorator {
    public EcoModeDecorator(Car car) {
        super(car);
    }
    @Override
    public void assemble() {
        super.assemble();
        addEcoModeFeature();
    }
    private void addEcoModeFeature() {
        System.out.println("Adding Eco-Mode feature");
        Engine engine = null;

        // Handle different car types
        if (decoratedCar instanceof BasicCar) {
            engine = ((BasicCar) decoratedCar).getEngine();
        } else if (decoratedCar instanceof SportsCar) {
            engine = ((SportsCar) decoratedCar).getEngine();
        }

        if (engine != null) {
            engine.addHorsePower(-50); // Reduce horse power by 50 due to Eco-Mode
        }
    }
}

// Client: Testing the Decorators with Multiple Car Types
public class Decorator {
    public static void main(String[] args) {
        // Basic Car Scenario
        System.out.println("=== Basic Car Scenario ===");
        // Create an engine for basic car
        Engine basicEngine = new Engine("V6", 300);
        // Create a basic car with the engine
        Car basicCar = new BasicCar(basicEngine);
        System.out.println("\nBasic Car:");
        basicCar.assemble();

        // Decorate basic car
        Car turboBasisCar = new TurboDecorator(basicCar);
        System.out.println("\nBasic Car with Turbo:");
        turboBasisCar.assemble();

        // Sports Car Scenario
        System.out.println("\n=== Sports Car Scenario ===");
        // Create an engine for sports car
        Engine sportsEngine = new Engine("V8", 500);
        // Create a sports car with the engine
        Car sportsCar = new SportsCar(sportsEngine, "Roadster");
        System.out.println("\nSports Car:");
        sportsCar.assemble();

        // Decorate sports car with multiple features
        Car superchargedSportsCar = new SuperchargerDecorator(sportsCar);
        System.out.println("\nSports Car with Supercharger:");
        superchargedSportsCar.assemble();

        Car ecoSportsCar = new EcoModeDecorator(superchargedSportsCar);
        System.out.println("\nSports Car with Supercharger and Eco-Mode:");
        ecoSportsCar.assemble();
    }
}
