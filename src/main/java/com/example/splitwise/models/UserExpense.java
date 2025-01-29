package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class UserExpense extends BaseEntity{
    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
    private double amount;
    @Enumerated(value = EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
}
