package com.example.splitwise.models;

import lombok.*;

@Getter
@Setter
public class Transaction {
    public Transaction(User userFrom, User userTo, double amount) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
    }

    private User userFrom;
    private User userTo;
    private double amount;

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}