package designPatterns.strategy.paymentStrategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    String cardNumber;

    public CreditCardPaymentStrategy(String cardNumber){
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid "+ amount + " using Credit Card: " + this.cardNumber);
    }
}
