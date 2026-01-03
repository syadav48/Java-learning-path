package Interview.solid.Lsp;

public class AccountRecorder {
    public static void main(String[] args) {
        SavingCurrentAccount savingCurrentAccount = new SavingCurrentAccount(10000);
        FixedAccount fixedAccount = new FixedAccount(5000, 6);
        savingCurrentAccount.deposit(30000);
        fixedAccount.withdraw(4000);
    }
}
