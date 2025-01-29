package com.example.splitwise.dtos;

import com.example.splitwise.models.UserExpense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupRequestDTO {

    private int groupID;

    public int getGroupID() {
        return groupID;
    }
    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

}
