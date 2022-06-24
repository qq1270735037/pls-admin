package com.cqu.pls.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Advertisementinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
public class Advertisementinfo implements Serializable {
    private static final long serialVersionUID = 974213785492429353L;
    
    private Integer adId;
    
    private Integer employeeId;
    
    private String adContent;
    
    private String adMoney;
    
    private String adAdviser;
    
    private Date adStart;
    
    private Date adEnd;
    
    private String adImages;


    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }

    public String getAdMoney() {
        return adMoney;
    }

    public void setAdMoney(String adMoney) {
        this.adMoney = adMoney;
    }

    public String getAdAdviser() {
        return adAdviser;
    }

    public void setAdAdviser(String adAdviser) {
        this.adAdviser = adAdviser;
    }

    public Date getAdStart() {
        return adStart;
    }

    public void setAdStart(Date adStart) {
        this.adStart = adStart;
    }

    public Date getAdEnd() {
        return adEnd;
    }

    public void setAdEnd(Date adEnd) {
        this.adEnd = adEnd;
    }

    public String getAdImages() {
        return adImages;
    }

    public void setAdImages(String adImages) {
        this.adImages = adImages;
    }

}

