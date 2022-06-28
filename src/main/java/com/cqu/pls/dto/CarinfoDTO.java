package com.cqu.pls.dto;

import com.cqu.pls.entity.Carinfo;
import lombok.Data;
@Data
public class CarinfoDTO extends Carinfo {
        private Long page;//当前页码
        private Long limit;//每页条数
}
