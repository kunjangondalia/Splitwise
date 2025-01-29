package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "users")
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

}
