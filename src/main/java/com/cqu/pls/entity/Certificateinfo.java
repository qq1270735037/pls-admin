package com.cqu.pls.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Certificateinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public class Certificateinfo implements Serializable {
    private static final long serialVersionUID = 738764997263637676L;
    
    private Integer certificateId;
    
    private Integer employeeId;
    
    private Integer certificateCode;
    
    private String certificateName;
    
    private Date certificateStartTime;
    
    private Date certificateEndTime;
    
    private String certificateAgent;


    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(Integer certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public Date getCertificateStartTime() {
        return certificateStartTime;
    }

    public void setCertificateStartTime(Date certificateStartTime) {
        this.certificateStartTime = certificateStartTime;
    }

    public Date getCertificateEndTime() {
        return certificateEndTime;
    }

    public void setCertificateEndTime(Date certificateEndTime) {
        this.certificateEndTime = certificateEndTime;
    }

    public String getCertificateAgent() {
        return certificateAgent;
    }

    public void setCertificateAgent(String certificateAgent) {
        this.certificateAgent = certificateAgent;
    }

}

