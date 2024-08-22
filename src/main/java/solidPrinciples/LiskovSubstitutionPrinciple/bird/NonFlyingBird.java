package solidPrinciples.LiskovSubstitutionPrinciple.bird;

public class NonFlyingBird extends Bird{
    @Override
    public void move(){
        System.out.println("The bird can't fly");
    }
}
