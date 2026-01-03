package Interview.solid.Lsp;

public class SavingCurrentAccount extends NormalAccount {
    private long initialAmount;

    public SavingCurrentAccount(long initialAmount) {
        this.initialAmount = initialAmount;
    }


    @Override
    long deposit(long amount) {
        initialAmount += amount;
        return initialAmount;
    };

    @Override
    long withdraw(long amount) {
        initialAmount -= amount;
        return initialAmount;
    }
}
