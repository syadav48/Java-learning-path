package Interview.solid.Lsp.gptImplementation;

public abstract class Account {
    protected long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long deposit(long amount) {
        balance += amount;
        return balance;
    }

    public long getBalance() {
        return balance;
    }
}

