package solidproject.bankingProject.model;

import java.util.UUID;

public class Customer {
  private AccountDetails accountDetails;
   private String name;
   private UUID UUID;
   private String mobileNo;

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public Customer(AccountDetails accountDetails, String name, UUID UUID, String mobileNo) {
        this.accountDetails = accountDetails;
        this.name = name;
        this.UUID = UUID;
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }
}
