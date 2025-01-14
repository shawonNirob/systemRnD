package designPatterns.structural;

import java.util.logging.Logger;

interface CarEngine{
    void startEngine();
    void stopEngine();
}

class RealCarEngine implements CarEngine{
    @Override
    public void startEngine() {
        System.out.println("Engine is starting...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine is stopping...");
    }
}

class CarEngineProxy implements CarEngine{
    private RealCarEngine realCarEngine;
    private boolean isAuthorized;
    private static final Logger logger = Logger.getLogger(CarEngineProxy.class.getName());

    public CarEngineProxy(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    @Override
    public void startEngine() {
        logAction("StartEngine");

        if(isAuthorized){
            if(realCarEngine == null){
                realCarEngine = new RealCarEngine();
            }
            long startTime = System.nanoTime();
            realCarEngine.startEngine();
            long endTime = System.nanoTime();

            logPerformance("StartEngine", startTime, endTime);
        }else{
            System.out.println("Not Authorized");
        }
    }

    @Override
    public void stopEngine() {
        logAction("StopEngine");

        if(isAuthorized){
            if(realCarEngine == null){
                realCarEngine = new RealCarEngine();
            }
            long startTime = System.nanoTime();
            realCarEngine.stopEngine();
            long endTime = System.nanoTime();

            logPerformance("StopEngine", startTime, endTime);
        }else {
            System.out.println("Not Authorized");
        }
    }


    private void logAction(String action){
        logger.info(() -> "Attempting to" + action + ".....");
    }

    private void logPerformance(String action, long startTime, long endTime){
        long duration = endTime - startTime;
        logger.info(() -> action + " completed in " + duration / 1_000_000.0 + " ns");
    }
}

public class Proxy {
    public static void main(String[] args) {
        CarEngine proxy = new CarEngineProxy(false);
        proxy.startEngine();
        proxy.stopEngine();

        CarEngine proxy2 = new CarEngineProxy(true);
        proxy2.startEngine();
        proxy2.stopEngine();
    }
}
