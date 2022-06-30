package com.cqu.pls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Transportationinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
@NoArgsConstructor
@AllArgsConstructor
public class Transportationinfo implements Serializable {
    private static final long serialVersionUID = -73190779133642339L;
    
    private Long transportationId;
    
    private Integer carId;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date transportationStartTime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date transportationEndTime;
    
    private String transportationStartLocation;
    
    private String transportationEndLocation;
    
    private String transportationMoney;


    public Long getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(Long transportationId) {
        this.transportationId = transportationId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Date getTransportationStartTime() {
        return transportationStartTime;
    }

    public void setTransportationStartTime(Date transportationStartTime) {
        this.transportationStartTime = transportationStartTime;
    }

    public Date getTransportationEndTime() {
        return transportationEndTime;
    }

    public void setTransportationEndTime(Date transportationEndTime) {
        this.transportationEndTime = transportationEndTime;
    }

    public String getTransportationStartLocation() {
        return transportationStartLocation;
    }

    public void setTransportationStartLocation(String transportationStartLocation) {
        this.transportationStartLocation = transportationStartLocation;
    }

    public String getTransportationEndLocation() {
        return transportationEndLocation;
    }

    public void setTransportationEndLocation(String transportationEndLocation) {
        this.transportationEndLocation = transportationEndLocation;
    }

    public String getTransportationMoney() {
        return transportationMoney;
    }

    public void setTransportationMoney(String transportationMoney) {
        this.transportationMoney = transportationMoney;
    }

    @Override
    public String toString() {
        return "Transportationinfo{" +
                "transportationId=" + transportationId +
                ", carId=" + carId +
                ", transportationStartTime=" + transportationStartTime +
                ", transportationEndTime=" + transportationEndTime +
                ", transportationStartLocation='" + transportationStartLocation + '\'' +
                ", transportationEndLocation='" + transportationEndLocation + '\'' +
                ", transportationMoney='" + transportationMoney + '\'' +
                '}';
    }
}

