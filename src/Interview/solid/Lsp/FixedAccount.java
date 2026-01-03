package Interview.solid.Lsp;

public class FixedAccount extends FixedDepositAccount {
    private long initialAmount;
    private int maturityYears;

    public FixedAccount(long initialAmount, int maturityYears) {
        this.initialAmount = initialAmount;
        this.maturityYears = maturityYears;
    }


    @Override
    long deposit(long amount) {
        initialAmount += amount;
        return initialAmount;
    };

    @Override
    long withdraw(long amount) {
        if(maturityYears > 5){
            initialAmount -= amount;
        }
        return initialAmount;
    }
}

