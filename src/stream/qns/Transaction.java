package stream.qns;

import java.time.LocalDate;

public class Transaction {
    public enum Type { CREDIT, DEBIT, REFUND }

    private final String txnId;
    private final Type type;
    private final double amount;
    private final LocalDate date;

    public Transaction(String txnId, Type type, double amount, LocalDate date) {
        this.txnId = txnId;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getTxnId() { return txnId; }
    public Type getType() { return type; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
}

