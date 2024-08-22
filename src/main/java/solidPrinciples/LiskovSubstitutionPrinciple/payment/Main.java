package solidPrinciples.LiskovSubstitutionPrinciple.payment;

public class Main {
    public static void pay(Payment payment, double amount) {
        payment.pay(amount);
    }
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment();
        Payment cashPayment = new CashPayment();

        pay(creditCardPayment, 100);
        pay(cashPayment, 50);
    }
}
