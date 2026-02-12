package company.mockdata.model;

import company.mockdata.enums.TransactionType;

import java.time.LocalDate;

public class Transaction {
    private Long id;
    private TransactionType type;
    private double amount;
    private LocalDate date;
    private String reference;

    public Transaction(Long id, TransactionType type,
                       double amount, LocalDate date,
                       String reference) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.reference = reference;
    }

    // getters

    public Long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getReference() {
        return reference;
    }
}

