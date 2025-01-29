package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "grp")
@Getter
@Setter
public class Group extends BaseEntity{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    private String name;
    private String description;
    @ManyToMany
    private List<User> userList;
    @OneToMany
    private List<Expense> expenses;

    public List<Expense> getExpenses(){
        return expenses;
    }
}
