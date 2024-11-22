package advancedLLMs;

/*
public class Engine {
    private String type;
    private int horsePower;
    private int cylinders;
    private boolean pollutionStatus; // true if eco-friendly, false otherwise

    // Constructor to initialize the engine attributes
    public Engine(String type, int horsePower, int cylinders, boolean pollutionStatus) {
        this.type = type;
        this.horsePower = horsePower;
        this.cylinders = cylinders;
        this.pollutionStatus = pollutionStatus;
    }

    // Getter methods
    public String getType() {
        return type;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getCylinders() {
        return cylinders;
    }

    // The pollution status method
    public boolean isPollutionStatus() {
        return pollutionStatus;
    }

    // For simulation purposes, print out engine details
    @Override
    public String toString() {
        return "Engine [type=" + type + ", horsePower=" + horsePower + ", cylinders=" + cylinders + ", pollutionStatus=" + pollutionStatus + "]";
    }

    public class EngineBuilder {
        private String type;
        private int horsePower;
        private int cylinders;
        private boolean pollutionStatus; // true if eco-friendly, false otherwise

        // Setters for building the engine
        public EngineBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public EngineBuilder setHorsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        public EngineBuilder setCylinders(int cylinders) {
            this.cylinders = cylinders;
            return this;
        }

        public EngineBuilder setPollutionStatus(boolean pollutionStatus) {
            this.pollutionStatus = pollutionStatus;
            return this;
        }

        // Build the Engine
        public Engine build() {
            return new Engine(type, horsePower, cylinders, pollutionStatus);
        }
    }
}

public class EngineSimulator {

    // Simulate engine behavior based on type and properties
    public void simulateEngine(Engine engine) {
        System.out.println("\nSimulating Engine: " + engine.getType());

        // Simulate behavior based on the engine type
        if (engine.getType().equals("HighPerformance")) {
            if (engine.getHorsePower() > 450 && !engine.isPollutionStatus()) {
                System.out.println("High Performance Engine: Power meets requirements, and there is no pollution.");
            } else {
                System.out.println("High Performance Engine: Performance or pollution doesn't meet standards.");
            }
        } else if (engine.getType().equals("Standard")) {
            if (engine.getHorsePower() >= 300 && engine.getHorsePower() <= 450 && !engine.isPollutionStatus()) {
                System.out.println("Standard Engine: Meets performance and environmental criteria.");
            } else {
                System.out.println("Standard Engine: Performance or pollution doesn't meet standards.");
            }
        } else if (engine.getType().equals("EcoFriendly")) {
            if (engine.getHorsePower() <= 250 && engine.isPollutionStatus()) {
                System.out.println("Eco Friendly Engine: Meets performance and low pollution standards.");
            } else {
                System.out.println("Eco Friendly Engine: Performance or pollution doesn't meet standards.");
            }
        } else {
            System.out.println("Unknown Engine Type: Cannot simulate.");
        }
    }
}

public class EngineSystem {
    private EngineSimulator engineSimulator;

    public EngineSystem() {
        // Initialize simulator
        this.engineSimulator = new EngineSimulator();
    }

    // Create and simulate HighPerformance Engine
    public void simulateHighPerformanceEngine() {
        Engine highPerformanceEngine = new Engine.EngineBuilder()
                .setType("HighPerformance")
                .setHorsePower(600)
                .setCylinders(8)
                .setPollutionStatus(false)
                .build();
        engineSimulator.simulateEngine(highPerformanceEngine);
    }

    // Create and simulate Standard Engine
    public void simulateStandardEngine() {
        Engine standardEngine = new Engine.EngineBuilder()
                .setType("Standard")
                .setHorsePower(400)
                .setCylinders(6)
                .setPollutionStatus(false)
                .build();
        engineSimulator.simulateEngine(standardEngine);
    }

    // Create and simulate EcoFriendly Engine
    public void simulateEcoFriendlyEngine() {
        Engine ecoFriendlyEngine = new Engine.EngineBuilder()
                .setType("EcoFriendly")
                .setHorsePower(200)
                .setCylinders(4)
                .setPollutionStatus(true)
                .build();
        engineSimulator.simulateEngine(ecoFriendlyEngine);
    }
}

public class EngineTest {

    public static void main(String[] args) {
        // Initialize the engine system
        EngineSystem engineSystem = new EngineSystem();

        // Simulate different engines
        engineSystem.simulateHighPerformanceEngine();
        engineSystem.simulateStandardEngine();
        engineSystem.simulateEcoFriendlyEngine();
    }
}

 */
