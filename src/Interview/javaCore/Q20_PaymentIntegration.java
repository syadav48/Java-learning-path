package Interview.javaCore;

public class Q20_PaymentIntegration {
    private final PaymentIntegration paymentIntegration;
    public Q20_PaymentIntegration(PaymentIntegration paymentIntegration){
        this.paymentIntegration = paymentIntegration;
    }
    public void process(double amount) {
        paymentIntegration.initialPayment(amount);
        paymentIntegration.validatePayment("TXN12345");
        paymentIntegration.refund("TXN12345");
    }
    public static void main(String[] args) {
        PaymentIntegration paymentIntegration1 = new PhonePayGatway();
        paymentIntegration1.initialPayment(2000.30);
        paymentIntegration1.validatePayment("TXN:303030303030303CTV");
        paymentIntegration1.refund("TXN01000200202");

    }
}
