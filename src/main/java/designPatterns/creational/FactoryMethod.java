package designPatterns.creational;

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Dog makeSound: Woof! Woof!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Cat makeSound: Meow! Meow!");
    }
}

abstract class AnimalFactory {
    abstract Animal getAnimal();
}

class DogFactory extends AnimalFactory {
    public Animal getAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    public Animal getAnimal() {
        return new Cat();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.getAnimal();
        dog.makeSound();

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.getAnimal();
        cat.makeSound();
    }
}
