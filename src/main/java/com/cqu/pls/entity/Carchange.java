package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Carchange)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@NoArgsConstructor
@AllArgsConstructor
public class Carchange implements Serializable {
    private static final long serialVersionUID = -39291476994177275L;
    
    private Integer carChangeId;
    
    private Integer carId;
    
    private String carChangeType;
    
    private Integer operation;


    public Integer getCarChangeId() {
        return carChangeId;
    }

    public void setCarChangeId(Integer carChangeId) {
        this.carChangeId = carChangeId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarChangeType() {
        return carChangeType;
    }

    public void setCarChangeType(String carChangeType) {
        this.carChangeType = carChangeType;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Carchange{" +
                "carChangeId=" + carChangeId +
                ", carId=" + carId +
                ", carChangeType='" + carChangeType + '\'' +
                ", operation=" + operation +
                '}';
    }
}

