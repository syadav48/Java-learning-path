package Interview.javaCore;

public class PhonePayGatway implements PaymentIntegration {
    @Override
    public void initialPayment(double amount) {
        System.out.println("Paytm: Initiating payment of ₹" + amount);
    }

    @Override
    public boolean validatePayment(String paymentId) {
        System.out.println("Paytm: Validating " + paymentId);
        return true;
    }

    @Override
    public void refund(String paymentId) {
        System.out.println("Paytm: Refunding for " + paymentId);
    }
}
