package ProjectWiseLearning.OOPS.SmartLibrary.payment;

public class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid via UPI: " + amount);
    }
}

