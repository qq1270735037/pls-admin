package com.cqu.pls.dto;

import com.cqu.pls.entity.Matetialinfo;
import lombok.Data;

@Data
public class MaterialInfoDTO extends Matetialinfo {
    private Long page;//当前页码
    private Long limit;//每页条数
}
