package designPatterns.strategy.paymentStrategy;

public class RazorPayPaymentStrategy implements PaymentStrategy {
    String upiId;

    public RazorPayPaymentStrategy(String upiId){
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid "+ amount + " using UPI ID: " + this.upiId);
    }
}
