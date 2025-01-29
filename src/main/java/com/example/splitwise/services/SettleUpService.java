package com.example.splitwise.services;

import com.example.splitwise.models.*;
import com.example.splitwise.repositories.ExpenseRepository;
import com.example.splitwise.repositories.GroupRepository;
import com.example.splitwise.repositories.UserRepository;
import com.example.splitwise.stratergies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

@Service
public class SettleUpService {

    UserRepository userRepository;
    GroupRepository groupRepository;
    ExpenseRepository expenseRepository;

    @Autowired
    @Qualifier("HeapSettleUpStrategy")
    private SettleUpStrategy settleUpStrategy;

    @Autowired
    public SettleUpService(UserRepository userRepository,
                           GroupRepository groupRepository,
                           ExpenseRepository expenseRepository){
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Transaction> settleUpGroup(int groupID){

        Optional<Group> groupOptional = groupRepository.findById(groupID);

        if(groupOptional.isEmpty()){
            throw new RuntimeException("Group not found");
        }
        Group group = groupOptional.get();

        List<Expense> expenses = group.getExpenses();

        return settleUpStrategy.settleUp(expenses);
    }
}
