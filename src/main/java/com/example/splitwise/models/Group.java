package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "groups")
@Getter
@Setter
public class Group extends BaseEntity{
    private String name;
    private String description;
    @ManyToMany
    private List<User> userList;
    @OneToMany
    private List<Expense> expenses;
}
