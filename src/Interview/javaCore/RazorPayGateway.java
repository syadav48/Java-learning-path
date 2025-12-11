package Interview.javaCore;

public class RazorPayGateway implements PaymentIntegration {


    @Override
    public void initialPayment(double amount) {
        System.out.println("Razorpay: Initiating payment of ₹" + amount);
    }

    @Override
    public boolean validatePayment(String paymentId) {
        System.out.println("Razorpay: Validating " + paymentId);
        return true;
    }

    @Override
    public void refund(String paymentId) {
        System.out.println("Razorpay: Refunding for " + paymentId);
    }
}
