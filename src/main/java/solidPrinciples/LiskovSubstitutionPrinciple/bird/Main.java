package solidPrinciples.LiskovSubstitutionPrinciple.bird;

public class Main {
    public static void makeBirdFly(Bird bird) {
        bird.move();
    }
    public static void main(String[] args) {
        Bird flyingBird = new FlyingBird();
        Bird nonFlyringBird = new NonFlyingBird();

        makeBirdFly(flyingBird);
        makeBirdFly(nonFlyringBird);
    }
}
