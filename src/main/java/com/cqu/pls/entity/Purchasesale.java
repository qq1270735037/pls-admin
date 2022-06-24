package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Purchasesale)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
@NoArgsConstructor
@AllArgsConstructor
public class Purchasesale implements Serializable {
    private static final long serialVersionUID = -62727252257942799L;
    
    private Integer purchasesaleId;
    
    private String purchasesaleType;
    
    private Double purchasesalePrice;
    
    private Integer purchasesaleCount;


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

    @Override
    public String toString() {
        return "Purchasesale{" +
                "purchasesaleId=" + purchasesaleId +
                ", purchasesaleType='" + purchasesaleType + '\'' +
                ", purchasesalePrice=" + purchasesalePrice +
                ", purchasesaleCount=" + purchasesaleCount +
                '}';
    }
}

