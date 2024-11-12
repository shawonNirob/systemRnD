package oops;


class Engine1{
    public void start(){
        System.out.println("Start");
    }
}

class car{
    private Engine1 engine;

    public car(Engine1 engine){
        engine = new Engine1();
    }
    public void start(){
        engine.start();
    }
}

public class MockitoTestObject {
    public static void main(String[] args) {

    }
}