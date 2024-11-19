package designPatterns.creational;

interface CarPrototype {
    CarPrototype clone();
}

class Car implements CarPrototype {
    private String name;
    private String color;
    private int price;
    private String model;

    public Car(String name, String color, int price, String model) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.model = model;
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getPrice() {
        return price;
    }
    public String getModel() {
        return model;
    }

    @Override
    public CarPrototype clone() {
        return new Car(this.name, this.color, this.price, this.model);
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", color=" + color + ", price=" + price + ", model=" + model + "]";
    }
}

public class Prototype {
    public static void main(String[] args) {
        CarPrototype carPrototype = new Car("Car", "blue", 1000, "Mustang");
        System.out.println(carPrototype);

        CarPrototype carClone1 = carPrototype.clone();
        System.out.println(carClone1);

        CarPrototype carClone2 = carPrototype.clone();
        System.out.println(carClone2);
    }
}
