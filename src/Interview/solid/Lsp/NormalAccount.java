package Interview.solid.Lsp;

public abstract class NormalAccount implements Account{
    abstract long deposit(long amount);
    abstract long withdraw(long amount);
}
