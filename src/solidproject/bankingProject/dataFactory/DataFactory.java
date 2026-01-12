package solidproject.bankingProject.dataFactory;

import solidproject.bankingProject.model.AccountDetails;
import solidproject.bankingProject.model.Customer;

import java.util.UUID;

public class DataFactory {
    public static Customer getCustomer(){
        long accountNumber = 1002008904;
        String accountType = "SAVING";
        String ifscNO = "SBIN00225";
        String branch = "TRIBENI";
        long currentBalance = 0;
        AccountDetails accountDetails = new AccountDetails(accountNumber, accountType, ifscNO, branch, currentBalance);
        return new Customer(accountDetails, "Suryoday", UUID.randomUUID(), "9903511417");
    }
}
