package solidproject.bankingProject.model;

public class AccountDetails {
    private final long accountNumber;
    private String accountType;
    private String ifscNO;
    private String branch;
    private long currentBalance;

    public AccountDetails(long accountNumber, String accountType, String ifscNO, String branch, long currentBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.ifscNO = ifscNO;
        this.branch = branch;
        this.currentBalance = currentBalance;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }
}
