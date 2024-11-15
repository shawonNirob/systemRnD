package designPatterns.creational;

// Product classes (Car and Engine)
class Car {
    private Engine engine;
    private String color;
    private String model;
    private int seats;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.color = builder.color;
        this.model = builder.model;
        this.seats = builder.seats;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", color=" + color + ", model=" + model + ", seats=" + seats + "]";
    }

    // Nested static Builder class to build Car object
    public static class Builder {
        private Engine engine;
        private String color;
        private String model;
        private int seats;

        public Builder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

class Engine {
    private String type;
    private int horsepower;
    private int cylinders;

    private Engine(EngineBuilder builder) {
        this.type = builder.type;
        this.horsepower = builder.horsepower;
        this.cylinders = builder.cylinders;
    }

    @Override
    public String toString() {
        return "Engine [type=" + type + ", horsepower=" + horsepower + ", cylinders=" + cylinders + "]";
    }

    // Nested static Builder class to build Engine object
    public static class EngineBuilder {
        private String type;
        private int horsepower;
        private int cylinders;

        public EngineBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public EngineBuilder setHorsepower(int horsepower) {
            this.horsepower = horsepower;
            return this;
        }

        public EngineBuilder setCylinders(int cylinders) {
            this.cylinders = cylinders;
            return this;
        }

        public Engine build() {
            return new Engine(this);
        }
    }
}

// Director class to manage the construction process
class CarDirector {
    public Car buildSportsCar() {
        // Create an Engine using the Engine Builder
        Engine engine = new Engine.EngineBuilder()
                .setType("V8")
                .setHorsepower(500)
                .setCylinders(8)
                .build();

        // Use Car Builder to build the Car with the Engine and other details
        return new Car.Builder()
                .setEngine(engine)
                .setColor("Red")
                .setModel("Sports")
                .setSeats(2)
                .build();
    }

    public Car buildSUV() {
        // Create an Engine using the Engine Builder
        Engine engine = new Engine.EngineBuilder()
                .setType("V6")
                .setHorsepower(300)
                .setCylinders(6)
                .build();

        // Use Car Builder to build the Car with the Engine and other details
        return new Car.Builder()
                .setEngine(engine)
                .setColor("Black")
                .setModel("SUV")
                .setSeats(5)
                .build();
    }
}

// Main class to demonstrate the Builder pattern
public class Builder {
    public static void main(String[] args) {
        CarDirector director = new CarDirector();

        // Building a sports car using the director
        Car sportsCar = director.buildSportsCar();
        System.out.println(sportsCar);

        // Building an SUV using the director
        Car suv = director.buildSUV();
        System.out.println(suv);
    }
}

