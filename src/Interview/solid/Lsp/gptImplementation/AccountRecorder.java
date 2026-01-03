package Interview.solid.Lsp.gptImplementation;

public class AccountRecorder {
    public static void main(String[] args) {

        Account fd = new FixedDepositAccount(5000, 6);
        fd.deposit(1000); // ✅ valid

        WithdrawableAccount savings = new SavingsAccount(10000);
        savings.withdraw(2000); // ✅ valid
    }
}

