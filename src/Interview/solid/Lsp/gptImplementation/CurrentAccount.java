package Interview.solid.Lsp.gptImplementation;

public class CurrentAccount extends WithdrawableAccount {

    public CurrentAccount(long balance) {
        super(balance);
    }

    @Override
    public long withdraw(long amount) {
        balance -= amount;
        return balance;
    }
}

