package designPatterns.creational;

// Product classes (Car and Engine)
class CarB{
    private EngineB engine;
    private String color;
    private String model;
    private int seats;

    private CarB(Builder builder){
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
    public static class Builder{
        private EngineB engine;
        private String color;
        private String model;
        private int seats;

        public Builder setEngine(EngineB engine){
            this.engine = engine;
            return this;
        }

        public Builder setColor(String color){
            this.color = color;
            return this;
        }

        public Builder setModel(String model){
            this.model = model;
            return this;
        }

        public Builder setSeats(int seats){
            this.seats = seats;
            return this;
        }

        public CarB build(){
            return new CarB(this);
        }
    }
}

// Product classes (Car and Engine)
class EngineB{
    private String type;
    private int horsePower;
    private int cylinders;

    private EngineB(EngineBuilder builder){
        this.type = builder.type;
        this.horsePower = builder.horsePower;
        this.cylinders = builder.cylinders;
    }

    @Override
    public String toString() {
        return "Engine [type=" + type + ", horsePower=" + horsePower + ", cylinders=" + cylinders + "]";
    }

    // Nested static EngineBuilder class to build Engine object
    public static class EngineBuilder{
        private String type;
        private int horsePower;
        private int cylinders;

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

        public EngineB build(){
            return new EngineB(this);
        }
    }
}

//Director class to manage the construction process
class CarDirector{
    public CarB buildSportsCar(){
        EngineB engine = new EngineB.EngineBuilder()
                .setType("V8")
                .setHorsePower(500)
                .setCylinders(9)
                .build();

        return new CarB.Builder()
                .setEngine(engine)
                .setColor("Blue")
                .setModel("lamborghini temerario")
                .setSeats(2)
                .build();
    }

    public CarB buildDefenderCar(){
        EngineB engine  = new EngineB.EngineBuilder()
                .setType("D400")
                .setHorsePower(300)
                .setCylinders(8)
                .build();

        return new CarB.Builder()
                .setEngine(engine)
                .setModel("Land Rover Defender")
                .setColor("Black")
                .setSeats(4)
                .build();
    }
}

public class Builder {
    public static void main(String[] args) {
        CarDirector carDirector = new CarDirector();


        CarB sportscar = carDirector.buildSportsCar();
        System.out.println(sportscar);

        CarB defender = carDirector.buildDefenderCar();
        System.out.println(defender);
    }
}
