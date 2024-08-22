package solidPrinciples.LiskovSubstitutionPrinciple.payment;

public class CreditCardPayment extends Payment {
    @Override
    public void pay(double amount){
        System.out.println("Credit Card Payment Method $" + amount);
    }
}
