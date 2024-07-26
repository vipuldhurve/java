package designPatterns.strategy.subscriptionPlans;

import designPatterns.strategy.Subscription;
import designPatterns.strategy.paymentStrategy.CreditCardPaymentStrategy;

public class PremiumPlan extends Subscription {
//  1-year plan
    private String creditCardNumber;

    public PremiumPlan( String creditCardNumber) {
        super(15_000);
        this.creditCardNumber = creditCardNumber;
        super.setPaymentStrategy(new CreditCardPaymentStrategy(creditCardNumber));
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
