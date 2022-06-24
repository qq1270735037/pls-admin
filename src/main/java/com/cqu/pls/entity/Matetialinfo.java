package com.cqu.pls.entity;

import java.io.Serializable;

/**
 * (Matetialinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public class Matetialinfo implements Serializable {
    private static final long serialVersionUID = -73356926628082869L;
    
    private Integer materialId;
    
    private Integer materialtypeId;
    
    private String materialName;
    
    private Double materialPrice;
    
    private String materialUsage;
    
    private Integer materialCount;


    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getMaterialtypeId() {
        return materialtypeId;
    }

    public void setMaterialtypeId(Integer materialtypeId) {
        this.materialtypeId = materialtypeId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Double getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(Double materialPrice) {
        this.materialPrice = materialPrice;
    }

    public String getMaterialUsage() {
        return materialUsage;
    }

    public void setMaterialUsage(String materialUsage) {
        this.materialUsage = materialUsage;
    }

    public Integer getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Integer materialCount) {
        this.materialCount = materialCount;
    }

    @Override
    public String toString() {
        return "Matetialinfo{" +
                "materialId=" + materialId +
                ", materialtypeId=" + materialtypeId +
                ", materialName='" + materialName + '\'' +
                ", materialPrice=" + materialPrice +
                ", materialUsage='" + materialUsage + '\'' +
                ", materialCount=" + materialCount +
                '}';
    }
}

