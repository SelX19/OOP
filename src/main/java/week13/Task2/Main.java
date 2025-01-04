package week13.Task2;

public class Main {
    public static void main(String[]args){
        PaymentFactory paymentFactory = new PaymentFactory();

        Payment creditCardPayment = paymentFactory.createPayment("Credit card");
        Payment payPal = paymentFactory.createPayment("PayPal");

        creditCardPayment.processPayment();
        payPal.processPayment();
    }
}
