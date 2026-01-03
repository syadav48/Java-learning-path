package Interview.solid.Lsp;

public abstract class FixedDepositAccount implements Account{
     abstract long deposit(long amount);
     abstract long withdraw(long amount);
}
