package week13.Task2;

public class CreditCardPayment implements Payment {
    @Override
    public void processPayment(){
        System.out.println("Payment being processed by credit card.");
    }
}
