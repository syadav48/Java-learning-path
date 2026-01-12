package solidproject.bankingProject.service;

import solidproject.bankingProject.model.AccountDetails;

public class PaymentService {
   private AccountDetails accountDetails;

    public PaymentService(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    public void deposit(long amount){
        long currentBalance = accountDetails.getCurrentBalance();
        currentBalance += amount;
        accountDetails.setCurrentBalance(currentBalance);
   }
    public void withdraw(long amount){
        long currentBalance = accountDetails.getCurrentBalance();
        currentBalance -= amount;
        accountDetails.setCurrentBalance(currentBalance);
    }
}
