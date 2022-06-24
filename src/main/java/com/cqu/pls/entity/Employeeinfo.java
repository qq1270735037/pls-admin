package com.cqu.pls.entity;

import java.io.Serializable;

/**
 * (Employeeinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public class Employeeinfo implements Serializable {
    private static final long serialVersionUID = -87648960516010549L;
    
    private Integer employeeId;
    
    private Integer companyId;
    
    private String employeeName;
    
    private String employeeGender;
    
    private String employeeAddress;
    
    private String employeeMobile;
    
    private String employeeDate;
    
    private String employeeStatus;
    
    private String employeeNumber;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(String employeeMobile) {
        this.employeeMobile = employeeMobile;
    }

    public String getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(String employeeDate) {
        this.employeeDate = employeeDate;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Employeeinfo{" +
                "employeeId=" + employeeId +
                ", companyId=" + companyId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeMobile='" + employeeMobile + '\'' +
                ", employeeDate='" + employeeDate + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                '}';
    }
}

