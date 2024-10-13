package oops;

class EmployeeAddress{
    String city;

    public EmployeeAddress(String city){
        this.city = city;
    }
}

class Employee implements Cloneable {
    String name;
    int age;
    EmployeeAddress address;

    public Employee(String name, int age, EmployeeAddress employeeAddress) {
        this.name = name;
        this.age = age;
        this.address = employeeAddress;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //defalut shallow copy
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", address=" + address.city + "]";
    }
}

public class ObjectClone {
    public static void main(String[] args) {
        try{
            EmployeeAddress employeeAddress = new EmployeeAddress("Banani");
            Employee e1 = new Employee("Nirob", 24, employeeAddress);
            Employee e2 = (Employee) e1.clone();

            e2.name = "Ayaz";
            e2.age = 4;
            e2.address.city = "Badda";


            System.out.println("e1: " +e1);
            System.out.println("e2: " +e2);

        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
