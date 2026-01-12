package solidproject.bankingProject.transaction;

import solidproject.bankingProject.dataFactory.DataFactory;
import solidproject.bankingProject.model.AccountDetails;
import solidproject.bankingProject.model.Customer;
import solidproject.bankingProject.service.PaymentService;

public class Transaction {
    public static void main(String[] args) {
        Customer customer = DataFactory.getCustomer();
        AccountDetails accountDetails = customer.getAccountDetails();
        PaymentService paymentService = new PaymentService(accountDetails);


        paymentService.deposit(1000);
        paymentService.deposit(1000);
        paymentService.withdraw(700);
        paymentService.deposit(1000);
        paymentService.deposit(1000);
        paymentService.withdraw(500);

        accountDetails.setCurrentBalance(5000);
        System.out.println(accountDetails.getCurrentBalance());
    }
}
