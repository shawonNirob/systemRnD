package oops;

class Address{
    String city;

    public Address(String city){
        this.city = city;
    }

    //deep copy constructor
    public Address(Address other){
        this.city = other.city;
    }
}

class PersonBd{
    String name;
    Address address;

    public PersonBd(String name, Address address){
        this.name = name;
        this.address = address;
    }

    //create a new Address object
    public PersonBd(PersonBd other){
        this.name = other.name;
        this.address = new Address(other.address);
    }

    @Override
    public String toString(){
        return "{name: " + name + " " + "address: "+ address.city + "}";
    }
}

public class DeepCopy {
    public static void main(String[] args) {
        Address address1 = new Address("Rangpur");
        PersonBd person1 = new PersonBd("Nirob", address1);

        // Deep copy of person1
        PersonBd person2 = new PersonBd(person1);

        person2.name = "Ayan";

        // Modifying the city of the deep copy does not affect the original object
        person2.address.city = "Kurigram";

        //person1.name = "Ayaz";

        System.out.println("Person1: "+person1);
        System.out.println("Person2: "+person2);
    }
}
