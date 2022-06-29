package com.cqu.pls.entity;

import java.io.Serializable;

/**
 * (Purchasesale)实体类
 *
 * @author makejava
 * @since 2022-06-29 10:59:33
 */
public class Purchasesale implements Serializable {
    private static final long serialVersionUID = 146460432932036963L;
    
    private Integer purchasesaleId;
    
    private String purchasesaleType;
    
    private Double purchasesalePrice;
    
    private Integer purchasesaleCount;
    
    private Integer merchandiseId;
    
    private String merchandiseName;


    public Integer getPurchasesaleId() {
        return purchasesaleId;
    }

    public void setPurchasesaleId(Integer purchasesaleId) {
        this.purchasesaleId = purchasesaleId;
    }

    public String getPurchasesaleType() {
        return purchasesaleType;
    }

    public void setPurchasesaleType(String purchasesaleType) {
        this.purchasesaleType = purchasesaleType;
    }

    public Double getPurchasesalePrice() {
        return purchasesalePrice;
    }

    public void setPurchasesalePrice(Double purchasesalePrice) {
        this.purchasesalePrice = purchasesalePrice;
    }

    public Integer getPurchasesaleCount() {
        return purchasesaleCount;
    }

    public void setPurchasesaleCount(Integer purchasesaleCount) {
        this.purchasesaleCount = purchasesaleCount;
    }

    public Integer getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(Integer merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public String getMerchandiseName() {
        return merchandiseName;
    }

    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName;
    }

}

