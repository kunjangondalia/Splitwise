package com.example.splitwise.controllers;

import com.example.splitwise.dtos.ResponseStatus;
import com.example.splitwise.dtos.SettleUpGroupResponseDTO;
import com.example.splitwise.dtos.SettleUpGroupRequestDTO;
import com.example.splitwise.models.Transaction;
import com.example.splitwise.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    @Autowired
    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO requestDTO){
        SettleUpGroupResponseDTO responseDTO = new SettleUpGroupResponseDTO();
        try{
            List<Transaction> transactionList = settleUpService.settleUpGroup(requestDTO.getGroupID());
            responseDTO.setTransactions(transactionList);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDTO.setFailureMessage(e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDTO;
    }
}
