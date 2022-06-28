package com.cqu.pls.dto;

import com.cqu.pls.entity.Machineinfo;
import lombok.Data;

@Data
public class MachineinfoDTO extends Machineinfo {
    private Long page;//当前页码
    private Long limit;//每页条数
}
