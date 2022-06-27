package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Addressinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:33:59
 */
@NoArgsConstructor
@AllArgsConstructor
public class Addressinfo implements Serializable {
    private static final long serialVersionUID = -57473611496414084L;
    
    private Integer addressId;
    
    private String addressProvince;
    
    private String addressCity;
    
    private String addressName;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public String toString() {
        return "Addressinfo{" +
                "addressId=" + addressId +
                ", addressProvince='" + addressProvince + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressName='" + addressName + '\'' +
                '}';
    }

}

