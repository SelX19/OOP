package week13.Task2;

public class PayPalPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("Payment being processed via PayPal.");
    }
}
