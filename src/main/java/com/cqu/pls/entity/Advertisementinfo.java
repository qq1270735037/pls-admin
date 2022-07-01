package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Advertisementinfo)实体类
 *
 * @author makejava
 * @since 2022-06-29 16:29:34
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Advertisementinfo implements Serializable {
    private static final long serialVersionUID = 879635802462968646L;
    
    private Integer adId;
    
    private String adContent;
    
    private String adMoney;
    
    private String adAdviser;
    
    private String adStart;
    
    private String adEnd;
    
    private String adImages;


    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
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

    public String getAdStart() {
        return adStart;
    }

    public void setAdStart(String adStart) {
        this.adStart = adStart;
    }

    public String getAdEnd() {
        return adEnd;
    }

    public void setAdEnd(String adEnd) {
        this.adEnd = adEnd;
    }

    public String getAdImages() {
        return adImages;
    }

    public void setAdImages(String adImages) {
        this.adImages = adImages;
    }

}

