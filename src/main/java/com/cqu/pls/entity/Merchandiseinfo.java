package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Merchandiseinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@NoArgsConstructor
@AllArgsConstructor
public class Merchandiseinfo implements Serializable {
    private static final long serialVersionUID = -19587627102359165L;
    
    private Integer merchandiseId;
    
    private Integer buildId;
    
    private Integer purchasesaleId;
    
    private String merchandiseName;
    
    private String merchandiseType;
    
    private Integer repositoryCount;
    
    private Integer merchandiseHeight;
    
    private Integer merchandiseSize;
    
    private String merchandiseSupplier;
    
    private Integer merchandiseCount;


    public Integer getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(Integer merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getPurchasesaleId() {
        return purchasesaleId;
    }

    public void setPurchasesaleId(Integer purchasesaleId) {
        this.purchasesaleId = purchasesaleId;
    }

    public String getMerchandiseName() {
        return merchandiseName;
    }

    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName;
    }

    public String getMerchandiseType() {
        return merchandiseType;
    }

    public void setMerchandiseType(String merchandiseType) {
        this.merchandiseType = merchandiseType;
    }

    public Integer getRepositoryCount() {
        return repositoryCount;
    }

    public void setRepositoryCount(Integer repositoryCount) {
        this.repositoryCount = repositoryCount;
    }

    public Integer getMerchandiseHeight() {
        return merchandiseHeight;
    }

    public void setMerchandiseHeight(Integer merchandiseHeight) {
        this.merchandiseHeight = merchandiseHeight;
    }

    public Integer getMerchandiseSize() {
        return merchandiseSize;
    }

    public void setMerchandiseSize(Integer merchandiseSize) {
        this.merchandiseSize = merchandiseSize;
    }

    public String getMerchandiseSupplier() {
        return merchandiseSupplier;
    }

    public void setMerchandiseSupplier(String merchandiseSupplier) {
        this.merchandiseSupplier = merchandiseSupplier;
    }

    public Integer getMerchandiseCount() {
        return merchandiseCount;
    }

    public void setMerchandiseCount(Integer merchandiseCount) {
        this.merchandiseCount = merchandiseCount;
    }

    @Override
    public String toString() {
        return "Merchandiseinfo{" +
                "merchandiseId=" + merchandiseId +
                ", buildId=" + buildId +
                ", purchasesaleId=" + purchasesaleId +
                ", merchandiseName='" + merchandiseName + '\'' +
                ", merchandiseType='" + merchandiseType + '\'' +
                ", repositoryCount=" + repositoryCount +
                ", merchandiseHeight=" + merchandiseHeight +
                ", merchandiseSize=" + merchandiseSize +
                ", merchandiseSupplier='" + merchandiseSupplier + '\'' +
                ", merchandiseCount=" + merchandiseCount +
                '}';
    }
}

