package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends BaseEntity{
    @ManyToOne
    private Group group;
    @Enumerated(value = EnumType.ORDINAL)
    private ExpenseType expenseType;
    @OneToMany
    private List<UserExpense> expenseFor;
    @OneToMany
    private List<UserExpense> expenseTo;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public List<UserExpense> getExpenseFor() {
        return expenseFor;
    }

    public void setExpenseFor(List<UserExpense> expenseFor) {
        this.expenseFor = expenseFor;
    }

    public List<UserExpense> getExpenseTo() {
        return expenseTo;
    }

    public void setExpenseTo(List<UserExpense> expenseTo) {
        this.expenseTo = expenseTo;
    }
}
