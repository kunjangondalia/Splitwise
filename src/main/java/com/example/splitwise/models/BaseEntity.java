package com.example.splitwise.models;

import jakarta.persistence.Id;

import java.util.Date;


public class BaseEntity {
    @Id
    long id;
    Date createdAt;
    Date updatedAt;
}
