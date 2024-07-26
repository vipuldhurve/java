package designPatterns.strategy.subscriptionPlans;

import designPatterns.strategy.Subscription;
import designPatterns.strategy.paymentStrategy.CreditCardPaymentStrategy;
import designPatterns.strategy.paymentStrategy.RazorPayPaymentStrategy;

public class GoldPlan extends Subscription {
    //6 months plan with emi options for creditCard payment type
    private String paymentId;

    private IdType idtype;

    public GoldPlan(IdType idtype, String paymentId) {
        super(8000);
        this.idtype = idtype;
        this.paymentId = paymentId;
        this.setPaymentStrategyByPaymentIdType();
    }

    protected void setPaymentStrategyByPaymentIdType() {
        if(this.idtype == IdType.CREDIT_CARD) this.setPaymentStrategy(new CreditCardPaymentStrategy(this.paymentId));
        else this.setPaymentStrategy(new RazorPayPaymentStrategy(this.paymentId));
    }

    public void setPaymentDetails(IdType idtype, String paymentId){
        this.idtype = idtype;
        this.paymentId = paymentId;
        setPaymentStrategyByPaymentIdType();
    }
}