package com.example.splitwise.dtos;


import com.example.splitwise.models.Transaction;
import com.example.splitwise.models.UserExpense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDTO {

    private List<Transaction> transactions;
    private ResponseStatus responseStatus;
    private String failureMessage;
    public String getFailureMessage() {
        return failureMessage;
    }
    public void setFailureMessage(String failureMessage){
        this.failureMessage = failureMessage;
    }
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

}
