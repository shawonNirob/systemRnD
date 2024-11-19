package designPatterns.creational;


import com.google.gson.Gson;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;

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

    public String toJason(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toXML() {
        return "<Car>" +
                "<Engine>" + engine.toXml() + "</Engine>" +
                "<Color>" + color + "</Color>" +
                "<Model>" + model + "</Model>" +
                "<Seats>" + seats + "</Seats>" +
                "</Car>";
    }

    public String toCSV(){
        return engine.toCSV() + "," + color + "," + model + "," + seats;
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

    public String toXml() {
        return "<EngineType>" + type + "</EngineType>" +
                "<Horsepower>" + horsePower + "</Horsepower>" +
                "<Cylinders>" + cylinders + "</Cylinders>";
    }

    public String toCSV(){
        return type + "," + horsePower + "," + cylinders;
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


        System.out.println();

        System.out.println("Text Representation: ");
        System.out.println(sportscar);

        System.out.println("JSON Representation: ");
        System.out.println(sportscar.toJason());

        System.out.println("XML Representation: ");
        System.out.println(sportscar.toXML());

        System.out.println("CSV Representation: ");
        System.out.println(sportscar.toCSV());
    }
}
