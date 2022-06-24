package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Buildinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@NoArgsConstructor
@AllArgsConstructor
public class Buildinfo implements Serializable {
    private static final long serialVersionUID = -55071142384680025L;
    
    private Integer buildId;
    
    private Integer addressId;
    
    private String bulidName;
    
    private String buildStyle;
    
    private Integer buildRent;
    
    private Integer buildArea;
    
    private String buildPerson;


    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getBulidName() {
        return bulidName;
    }

    public void setBulidName(String bulidName) {
        this.bulidName = bulidName;
    }

    public String getBuildStyle() {
        return buildStyle;
    }

    public void setBuildStyle(String buildStyle) {
        this.buildStyle = buildStyle;
    }

    public Integer getBuildRent() {
        return buildRent;
    }

    public void setBuildRent(Integer buildRent) {
        this.buildRent = buildRent;
    }

    public Integer getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(Integer buildArea) {
        this.buildArea = buildArea;
    }

    public String getBuildPerson() {
        return buildPerson;
    }

    public void setBuildPerson(String buildPerson) {
        this.buildPerson = buildPerson;
    }

    @Override
    public String toString() {
        return "Buildinfo{" +
                "buildId=" + buildId +
                ", addressId=" + addressId +
                ", bulidName='" + bulidName + '\'' +
                ", buildStyle='" + buildStyle + '\'' +
                ", buildRent=" + buildRent +
                ", buildArea=" + buildArea +
                ", buildPerson='" + buildPerson + '\'' +
                '}';
    }
}

