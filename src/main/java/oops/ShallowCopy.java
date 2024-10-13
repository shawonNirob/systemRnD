package oops;

class Adress{
    String city;

    public Adress(String city){
        this.city = city;
    }
}

class Person{
    String name;
    Adress adress;

    public Person(String name, Adress adress){
        this.name = name;
        this.adress = adress;
    }
    
    public Person(Person other){
        this.name = other.name;
        this.adress = other.adress;
    }

    @Override
    public String toString(){
        return "{name = " + name + ", adress = " + adress.city + "}";
    }
}

public class ShallowCopy {
    public static void main(String[] args) {
        Adress adress = new Adress("Rajshahi");
        Person person1 = new Person( "Nirob", adress);

        Person person2 = new Person(person1);
        person2.name = "Ayan";
        person2.adress.city = "Dhaka";

        //person1.name = "Ayaz";

        System.out.println("Person 1 adress: " + person1);
        System.out.println("Person 2 adress: " + person2);
    }
}
