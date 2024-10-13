package oops;

import java.util.ArrayList;
import java.util.List;

class Person1{
    String name;
    Integer age;
    List<Integer> marks;

    public Person1(String name, Integer age, List<Integer> marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    //Shallow copy
    public Person1(Person1 other){
        //In a copy constructor, copying an immutable type like String means copying the reference,
        //but since the string itself can’t be altered, it doesn’t lead to shared state issues
        this.name = other.name;

        //Primitive types (like int, char, boolean, etc.) store their values directly.
        // When you copy a primitive type, you copy the actual value.
        this.age = other.age;

        // Copies the reference, not the actual list
        this.marks = other.marks;
    }


    @Override
    public String toString(){
        return "Person {name=" + name + ", age=" + age + ", array="+ marks + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();
        marks.add(1);
        marks.add(2);

        Person1 original = new Person1("John", 20, marks);
        Person1 copy = new Person1(original);

        System.out.println("original:" + original);
        System.out.println("copy:" + copy);

        copy.name = "Nirob";
        copy.age = 24;
        marks.add(3);
        marks.add(4);
        copy.marks = marks;

        System.out.println("original:" + original);
        System.out.println("copy:" + copy);
    }
}