package Interview.javaCore.interfaceExample;

public class RazorPay implements payment, Refund, SecurityCheck{
    @Override
    public void refund(String paymentId) {
        System.out.println("Razorpay Payment of ₹" + paymentId);
    }

    @Override
    public boolean verifyUser(String userId) {
        System.out.println("Verifying " + userId);
        return true;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Razorpay Payment of ₹" + amount);
    }
}
