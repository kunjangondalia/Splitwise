package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    @ManyToMany
    private List<Group> groups;
}
