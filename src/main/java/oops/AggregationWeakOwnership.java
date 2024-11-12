package oops;

class EngineX{
    private String type;

    public EngineX(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void startEngine() {
        System.out.println("Engine "+ type + " started");
    }

    public void stopEngine() {
        System.out.println("Engine "+ type + " stopped");
    }
}

class CarX{
    private EngineX engine;

    public CarX(EngineX engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.startEngine();
        System.out.println("Lamborghini Temerario's Engine "+ engine.getType() + " started");
    }

    public void stopCar() {
        engine.stopEngine();
        System.out.println("Lamborghini Temerario's Engine "+ engine.getType() + " stopped");
    }
}

class BusX{
    private EngineX engine;

    public BusX(EngineX engine) {
        this.engine = engine;
    }

    public void startBus() {
        engine.startEngine();
        System.out.println("Modern Bus Engine "+ engine.getType() + " started");
    }

    public void stopBus() {
        engine.stopEngine();
        System.out.println("Modern Bus Engine "+ engine.getType() + " stopped");
    }
}

public class AggregationWeakOwnership {
    public static void main(String[] args) {
        EngineX carEngine = new EngineX("L411");
        EngineX busEngine = new EngineX("MAN E0");

        CarX car = new CarX(carEngine);
        BusX bus = new BusX(busEngine);

        car.startCar();
        car.stopCar();

        bus.startBus();
        bus.stopBus();
    }
}
