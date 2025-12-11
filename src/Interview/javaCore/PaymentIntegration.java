package Interview.javaCore;

public interface PaymentIntegration {
    void initialPayment(double amount);
    boolean validatePayment(String paymentId);

    void refund(String paymentId);
}
