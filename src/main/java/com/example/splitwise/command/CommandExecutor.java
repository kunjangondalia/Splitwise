package com.example.splitwise.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands;
    private SettleUpGroupCommand settleUpGroupCommand;

    @Autowired
    public CommandExecutor(SettleUpGroupCommand settleUpGroupCommand) {
        commands = new ArrayList<Command>();
        this.settleUpGroupCommand = settleUpGroupCommand;
        commands.add(this.settleUpGroupCommand);
    }

    public void add(Command command) {
        commands.add(command);
    }

    public void remove(Command command) {
        commands.remove(command);
    }

    public void execute(String input) {
        for(Command command : commands) {
            if(command.matches(input)){
                command.execute(input);
            }
        }
    }
}
