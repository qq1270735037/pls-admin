package com.cqu.pls.vo;

import com.cqu.pls.entity.Communicationinfo;
import lombok.Data;

@Data
public class CommunicationAndEmployee extends Communicationinfo {
    private String employeeName;
}
