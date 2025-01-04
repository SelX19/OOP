package week13.Task2;

public class PaymentFactory {
    Payment createPayment(String type){
        switch(type){
            case "Credit card":
                return new CreditCardPayment();
            case "PayPal":
                return new PayPalPayment();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}
