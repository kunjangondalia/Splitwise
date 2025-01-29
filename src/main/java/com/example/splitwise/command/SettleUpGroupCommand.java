package com.example.splitwise.command;

import com.example.splitwise.controllers.SettleUpController;
import com.example.splitwise.dtos.ResponseStatus;
import com.example.splitwise.dtos.SettleUpGroupRequestDTO;
import com.example.splitwise.dtos.SettleUpGroupResponseDTO;
import com.example.splitwise.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpGroupCommand implements Command{
    @Autowired
    private SettleUpController settleUpController;

    @Override
    public boolean matches(String input) {
        List<String> words =  List.of(input.split(" "));
        if(words.size() == 2 && words.get(0).equals("SettleUpGroup")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words =  List.of(input.split(" "));
        Integer groupId = Integer.valueOf(words.get(1));

        SettleUpGroupRequestDTO request = new SettleUpGroupRequestDTO();
        request.setGroupID(groupId);

        SettleUpGroupResponseDTO responseDTO = settleUpController.settleUpGroup(request);
        System.out.println(responseDTO.getResponseStatus());
        if(responseDTO.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(responseDTO.getFailureMessage());
        } else {
            for(Transaction transaction : responseDTO.getTransactions()){
                System.out.println(transaction.getUserFrom().getName() + " should pay " + transaction.getUserTo().getName() + " : " + transaction.getAmount());
            }
        }
    }
}
