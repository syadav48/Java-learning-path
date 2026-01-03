package Interview.solid.Lsp.gptImplementation;

public class SavingsAccount extends WithdrawableAccount {

    public SavingsAccount(long balance) {
        super(balance);
    }

    @Override
    public long withdraw(long amount) {
        balance -= amount;
        return balance;
    }
}

