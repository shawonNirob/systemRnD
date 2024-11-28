package designPatterns.structural;

import java.util.HashMap;
import java.util.Map;

interface EngineFlyweight {
    void assemble();
}

class ConcreteEngine implements EngineFlyweight {
    private String type;
    private int horsePower;

    public ConcreteEngine(String type, int horsePower) {
        this.type = type;
        this.horsePower = horsePower;
    }

    @Override
    public void assemble() {
        System.out.println("Engine Type: " + type + ", HorsePower " + horsePower);
    }
}

class EngineFactory{
    private Map<String, EngineFlyweight> engineMap = new HashMap<>();

    public EngineFlyweight getEngine(String type, int horsePower) {
        String key = type + "_" + horsePower;

        if(!engineMap.containsKey(key)) {
            engineMap.put(key, new ConcreteEngine(type, horsePower));
        }

        return engineMap.get(key);
    }
}

class CarFlyweight{
    private String type;
    private EngineFlyweight engine;

    public CarFlyweight(String type, EngineFlyweight engine) {
        this.type = type;
        this.engine = engine;
    }

    public void assemble() {
        System.out.println("Assembling " + type + " Engine");
        engine.assemble();
    }
}

public class Flyweight {
    public static void main(String[] args) {
        EngineFactory engineFactory = new EngineFactory();

        EngineFlyweight engine1 = engineFactory.getEngine("V8", 500);
        EngineFlyweight engine2 = engineFactory.getEngine("S1", 800);

        CarFlyweight car1  =new CarFlyweight("Sports car", engine1);
        CarFlyweight car2  =new CarFlyweight("Super car", engine2);

        System.out.println("=== Assembling Cars ===");
        car1.assemble();
        car2.assemble();
    }
}
