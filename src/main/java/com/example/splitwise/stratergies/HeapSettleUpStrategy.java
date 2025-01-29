package com.example.splitwise.stratergies;

import com.example.splitwise.models.*;
import com.example.splitwise.models.UserExpense;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("HeapSettleUpStrategy")
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        HashMap<User, Double> expensesMap = new HashMap<>();
        for (Expense expense : expenses) {
            for (UserExpense expenseUser : expense.getExpenseFor()) {
                if (expensesMap.containsKey(expenseUser.getUser())) {
                    expensesMap.put(expenseUser.getUser(), expensesMap.get(expenseUser.getUser()) + expenseUser.getAmount());
                } else {
                    expensesMap.put(expenseUser.getUser(), expenseUser.getAmount());
                }
            }
            for (UserExpense expenseUser : expense.getExpenseTo()) {
                if (expensesMap.containsKey(expenseUser.getUser())) {
                    expensesMap.put(expenseUser.getUser(), expensesMap.get(expenseUser.getUser()) - expenseUser.getAmount());
                } else {
                    expensesMap.put(expenseUser.getUser(), expenseUser.getAmount()*(-1));
                }
            }
        }
        PriorityQueue<Map.Entry<User, Double>> positiveHeap = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );
        PriorityQueue<Map.Entry<User, Double>> negativeHeap = new PriorityQueue<>(
                (a, b) -> a.getValue().compareTo(b.getValue())
        );

        for (Map.Entry<User, Double> entry : expensesMap.entrySet()) {
            if (entry.getValue() > 0) {
                positiveHeap.offer(entry);
            } else if (entry.getValue() < 0) {
                negativeHeap.offer(entry);
            }
        }

        List<Transaction> settlements = new ArrayList<>();
        while (!positiveHeap.isEmpty() && !negativeHeap.isEmpty()) {
            Map.Entry<User, Double> positive = positiveHeap.poll();
            Map.Entry<User, Double> negative = negativeHeap.poll();

            double settlementAmount = Math.min(positive.getValue(), -negative.getValue());
            settlements.add(new Transaction(negative.getKey(), positive.getKey(), settlementAmount));

//            int positiveRemaining = positive.getValue() - settlementAmount;
//            int negativeRemaining = negative.getValue() + settlementAmount;
//
//            if (positiveRemaining > 0) {
//                positiveHeap.offer(new AbstractMap.SimpleEntry<>(positive.getKey(), positiveRemaining));
//            } else if (negativeRemaining < 0) {
//                negativeHeap.offer(new AbstractMap.SimpleEntry<>(negative.getKey(), negativeRemaining));
//            }

            positive.setValue(positive.getValue() - settlementAmount);
            negative.setValue(negative.getValue() + settlementAmount);

            if (positive.getValue() > 0) {
                positiveHeap.offer(positive);
            }
            if (negative.getValue() < 0) {
                negativeHeap.offer(negative);
            }
        }

        return settlements;
    }
}
