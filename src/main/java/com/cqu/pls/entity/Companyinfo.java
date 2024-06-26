package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Companyinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@NoArgsConstructor
@AllArgsConstructor
public class Companyinfo implements Serializable {
    private static final long serialVersionUID = -32149091902579236L;
    
    private Integer companyId;
    
    private String companyName;
    
    private Date companyTime;
    
    private String companyCity;
    
    private Integer companyNumber;
    
    private String companyWebside;
    
    private String companyCode;
    
    private String companyPerson;
    
    private String companyMobile;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getCompanyTime() {
        return companyTime;
    }

    public void setCompanyTime(Date companyTime) {
        this.companyTime = companyTime;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public Integer getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(Integer companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyWebside() {
        return companyWebside;
    }

    public void setCompanyWebside(String companyWebside) {
        this.companyWebside = companyWebside;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyPerson() {
        return companyPerson;
    }

    public void setCompanyPerson(String companyPerson) {
        this.companyPerson = companyPerson;
    }

    public String getCompanyMobile() {
        return companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
    }

    @Override
    public String toString() {
        return "Companyinfo{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyTime=" + companyTime +
                ", companyCity='" + companyCity + '\'' +
                ", companyNumber=" + companyNumber +
                ", companyWebside='" + companyWebside + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", companyPerson='" + companyPerson + '\'' +
                ", companyMobile=" + companyMobile +
                '}';
    }
}

