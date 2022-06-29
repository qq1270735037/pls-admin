package com.cqu.pls.dto;

import com.cqu.pls.entity.Buildinfo;
import lombok.Data;

@Data
public class BuildAndTypeDTO extends Buildinfo {
    private Long page;//当前页码
    private Long limit;//每页条数
}
