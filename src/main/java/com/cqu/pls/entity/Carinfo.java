package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Carinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@NoArgsConstructor
@AllArgsConstructor
public class Carinfo implements Serializable {
    private static final long serialVersionUID = 604572926163512041L;
    
    private Integer carId;
    
    private String carNumber;
    
    private String carStyle;
    
    private Double carLoad;
    
    private Double carMileage;
    
    private String carBrand;


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarStyle() {
        return carStyle;
    }

    public void setCarStyle(String carStyle) {
        this.carStyle = carStyle;
    }

    public Double getCarLoad() {
        return carLoad;
    }

    public void setCarLoad(Double carLoad) {
        this.carLoad = carLoad;
    }

    public Double getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(Double carMileage) {
        this.carMileage = carMileage;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    @Override
    public String toString() {
        return "Carinfo{" +
                "carId=" + carId +
                ", carNumber='" + carNumber + '\'' +
                ", carStyle='" + carStyle + '\'' +
                ", carLoad=" + carLoad +
                ", carMileage=" + carMileage +
                ", carBrand='" + carBrand + '\'' +
                '}';
    }
}

