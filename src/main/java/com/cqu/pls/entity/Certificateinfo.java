package com.cqu.pls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Certificateinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Certificateinfo implements Serializable {
    private static final long serialVersionUID = 738764997263637676L;


    
    private Integer certificateId;  //自增主键
    
    private Integer employeeId; //人员编号
    
    private Integer certificateCode; //证件编号
    
    private String certificateName; //证件名
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date certificateStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date certificateEndTime;
    
    private String certificateAgent; //发证单位



}

