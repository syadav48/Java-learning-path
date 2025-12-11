package Interview.javaCore.interfaceExample;

public class MultiInterface {
    public static void main(String[] args) {
        RazorPay razorPay = new RazorPay();
        System.out.println(razorPay.verifyUser("1001020"));
        razorPay.pay(0101.00);
        razorPay.verifyUser("9290202");
    }
}
