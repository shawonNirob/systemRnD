package designPatterns.structural;

interface CarSystem{
    void initialize();
    void shutdown();
}

class Fuelsystem implements CarSystem{
    public void pressurize(){
        System.out.println("Fuel System: fuel pressurize");
    }

    public void injectFuel(){
        System.out.println("Fuel System: fuel injecting to cylinder");
    }

    @Override
    public void initialize() {
        System.out.println("Fuel System: initialize");
        pressurize();
        injectFuel();
    }

    @Override
    public void shutdown() {
        System.out.println("Fuel System: shutdown");
    }
}


class ElectricalSystem implements CarSystem{
    public void startBattery(){
        System.out.println("Electrical System: startBattery");
    }

    public void checkAlternator(){
        System.out.println("Electrical System: checkAlternator");
    }

    @Override
    public void initialize() {
        System.out.println("Electrical System: initialize");
        startBattery();
        checkAlternator();
    }

    @Override
    public void shutdown() {
        System.out.println("Electrical System: shutdown");
    }
}

class IgnitionSystem implements CarSystem{
    public void generateSpark(){
        System.out.println("Ignition System: generateSpark");
    }

    public void distributeBattery(){
        System.out.println("Ignition System: distributeBattery");
    }

    @Override
    public void initialize() {
        System.out.println("Ignition System: initialize");
        generateSpark();
        distributeBattery();
    }

    @Override
    public void shutdown() {
        System.out.println("Ignition System: shutdown");
    }
}

class CoolingSystem implements CarSystem{
    public void startCirculation(){
        System.out.println("Cooling System: startCirculation");
    }

    public void regulateTemperature(){
        System.out.println("Cooling System: regulateTemperature");
    }

    @Override
    public void initialize() {
        System.out.println("Cooling System: initialize");
        startCirculation();
        regulateTemperature();
    }

    @Override
    public void shutdown() {
        System.out.println("Cooling System: shutdown");
    }
}

class CarFacade{
    Fuelsystem fuelsystem;
    ElectricalSystem electricalSystem;
    IgnitionSystem ignitionSystem;
    CoolingSystem coolingSystem;

    public CarFacade(){
        fuelsystem = new Fuelsystem();
        electricalSystem = new ElectricalSystem();
        ignitionSystem = new IgnitionSystem();
        coolingSystem = new CoolingSystem();
    }

    public void startEngine(){
        System.out.println("Car System: startEngine");

        fuelsystem.initialize();
        electricalSystem.initialize();
        ignitionSystem.initialize();
        coolingSystem.initialize();

        System.out.println("Car successfully started");
    }

    public void stopEngine(){
        System.out.println("Car System: stopEngine");

        fuelsystem.shutdown();
        electricalSystem.shutdown();
        ignitionSystem.shutdown();
        coolingSystem.shutdown();

        System.out.println("Car successfully stopped");
    }

    public void checkBattery(){
        electricalSystem.checkAlternator();
    }

    public void checkPressure(){
        fuelsystem.pressurize();
    }
}


public class Facade {
    public static void main(String[] args) {
        CarFacade facade = new CarFacade();

        System.out.println("====Start Driving====");
        facade.startEngine();

        System.out.println("====Additional System Check====");
        facade.checkBattery();
        facade.checkPressure();

        System.out.println("====End Drive====");
        facade.stopEngine();
    }
}
