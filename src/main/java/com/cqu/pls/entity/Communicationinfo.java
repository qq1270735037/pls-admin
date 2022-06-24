package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Communicationinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@NoArgsConstructor
@AllArgsConstructor
public class Communicationinfo implements Serializable {
    private static final long serialVersionUID = 388751034331797618L;
    
    private Integer communicationId;
    
    private Integer employeeId;
    
    private String communicationTitle;
    
    private String communicationContext;
    
    private Date communicationTime;


    public Integer getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(Integer communicationId) {
        this.communicationId = communicationId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getCommunicationTitle() {
        return communicationTitle;
    }

    public void setCommunicationTitle(String communicationTitle) {
        this.communicationTitle = communicationTitle;
    }

    public String getCommunicationContext() {
        return communicationContext;
    }

    public void setCommunicationContext(String communicationContext) {
        this.communicationContext = communicationContext;
    }

    public Date getCommunicationTime() {
        return communicationTime;
    }

    public void setCommunicationTime(Date communicationTime) {
        this.communicationTime = communicationTime;
    }

    @Override
    public String toString() {
        return "Communicationinfo{" +
                "communicationId=" + communicationId +
                ", employeeId=" + employeeId +
                ", communicationTitle='" + communicationTitle + '\'' +
                ", communicationContext='" + communicationContext + '\'' +
                ", communicationTime=" + communicationTime +
                '}';
    }
}

