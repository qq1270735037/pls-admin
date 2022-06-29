package com.cqu.pls.vo;

import com.cqu.pls.entity.Employeeinfo;
import lombok.Data;

@Data
public class EmployeeVo extends Employeeinfo {
    private String companyName;
}
