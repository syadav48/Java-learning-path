package Interview.solid.Lsp.gptImplementation;

public abstract class WithdrawableAccount extends Account {

    public WithdrawableAccount(long balance) {
        super(balance);
    }

    public abstract long withdraw(long amount);
}
