package com.example.splitwise.command;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}
