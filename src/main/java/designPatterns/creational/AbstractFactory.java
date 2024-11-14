package designPatterns.creational;

interface AnimalF{
    void makeSound();
}

interface AnimalFood{
    void serve();
}

class DogF implements AnimalF{
    public void makeSound() {
        System.out.println("I'm dog");
    }
}

class CatF implements AnimalF{
    public void makeSound() {
        System.out.println("I'm cat");
    }
}
class DogFood implements AnimalFood{
    public void serve() {
        System.out.println("Dog meat");
    }
}
class CatFood implements AnimalFood{
    public void serve() {
        System.out.println("Cat milk");
    }
}

interface AnimalFactoryF{
    AnimalF createAnimal();
    AnimalFood createAnimalFood();
}
class DogFactoryF implements AnimalFactoryF{
    public AnimalF createAnimal() {
        return new DogF();
    }
    public AnimalFood createAnimalFood() {
        return new DogFood();
    }
}
class CatFactoryF implements AnimalFactoryF{
    public AnimalF createAnimal() {
        return new CatF();
    }
    public AnimalFood createAnimalFood() {
        return new CatFood();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        AnimalFactoryF dogFactory = new DogFactoryF();
        AnimalF dog = dogFactory.createAnimal();
        dog.makeSound();
        AnimalFood dogFood = dogFactory.createAnimalFood();
        dogFood.serve();

        AnimalFactoryF catFactory = new CatFactoryF();
        AnimalF cat = catFactory.createAnimal();
        cat.makeSound();
        AnimalFood catFood = catFactory.createAnimalFood();
        catFood.serve();
    }
}

