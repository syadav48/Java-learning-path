package Interview.solid.Lsp.gptImplementation;

public class FixedDepositAccount extends Account {

    private final int maturityYears;

    public FixedDepositAccount(long balance, int maturityYears) {
        super(balance);
        this.maturityYears = maturityYears;
    }

    // No withdraw() here at all
}
