package oops;

class A {
    int value;

    A(int value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        A a = (A) obj;
        return value == a.value;
    }
}

public class Equals {
    public static void main(String[] args) {
        A obj1 = new A(10);
        A obj2 = new A(10);

        System.out.println(obj1.equals(obj2)); // true, compares content (value)

        char c = '5';
        System.out.println((int) 5 );

        int asciiValue = 5;
        char cr = (char) asciiValue;  // Converts 65 to 'A'
        System.out.println(cr);  // Output: 'A'

        int num = 5;
        char chr = (char) (num + '0');  // Converts 5 to '5'
        System.out.println(chr);  // Output: '5'

    }
}
