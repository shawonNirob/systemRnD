package oops;

class CarL{
    private EngineX engine;

    protected CarL(String model){
        this.engine = new EngineX(model);
    }

    protected void startCar() {
        engine.startEngine();
        System.out.println("Lamborghini Temerario's Engine "+ engine.getType() + " started");
    }

    protected void stopCar() {
        engine.stopEngine();
        System.out.println("Lamborghini Temerario's Engine " + engine.getType() + " stopped");
    }
}

class BusL{
    private EngineX engine;

    protected BusL(String model){
        this.engine = new EngineX(model);
    }

    protected void startBus() {
        engine.startEngine();
        System.out.println("Modern Bus Engine "+ engine.getType() + " started");
    }

    protected void stopBus() {
        engine.stopEngine();
        System.out.println("Modern Bus Engine "+ engine.getType() + " stopped");
    }
}

public class CompositionStrongOwnership {
    public static void main(String[] args) {
        CarL carL = new CarL("L 411");
        BusL busL = new BusL("MAN E0");

        carL.startCar();
        carL.stopCar();

        busL.startBus();
        busL.stopBus();
    }
}
