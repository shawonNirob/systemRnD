package solidPrinciples.LiskovSubstitutionPrinciple.bird;

public class FlyingBird extends Bird {
    @Override
    public void move(){
        System.out.println("Flying Bird");
    }
}
