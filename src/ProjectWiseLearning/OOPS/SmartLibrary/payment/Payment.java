package ProjectWiseLearning.OOPS.SmartLibrary.payment;

public interface Payment {

    void pay(double amount);

    default void printReceipt() {
        System.out.println("Payment successful");
    }
}
