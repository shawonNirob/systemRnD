package solidPrinciples.LiskovSubstitutionPrinciple.payment;

public class CashPayment extends Payment {
    @Override
    public void pay(double amount){
        System.out.println("Payment cash payment $" + amount);
    }
}
