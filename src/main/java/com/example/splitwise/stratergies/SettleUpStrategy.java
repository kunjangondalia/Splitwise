package com.example.splitwise.stratergies;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.Transaction;
import com.example.splitwise.models.UserExpense;

import java.util.List;

public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expenses);
}
