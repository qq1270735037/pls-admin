package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Fixinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@NoArgsConstructor
@AllArgsConstructor
public class Fixinfo implements Serializable {
    private static final long serialVersionUID = 342684618806152827L;
    
    private Integer fixId;
    
    private Integer carId;
    
    private Date fixStarttime;
    
    private Date fixEndtime;
    
    private String fixName;
    
    private Double fixMoney;


    public Integer getFixId() {
        return fixId;
    }

    public void setFixId(Integer fixId) {
        this.fixId = fixId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Date getFixStarttime() {
        return fixStarttime;
    }

    public void setFixStarttime(Date fixStarttime) {
        this.fixStarttime = fixStarttime;
    }

    public Date getFixEndtime() {
        return fixEndtime;
    }

    public void setFixEndtime(Date fixEndtime) {
        this.fixEndtime = fixEndtime;
    }

    public String getFixName() {
        return fixName;
    }

    public void setFixName(String fixName) {
        this.fixName = fixName;
    }

    public Double getFixMoney() {
        return fixMoney;
    }

    public void setFixMoney(Double fixMoney) {
        this.fixMoney = fixMoney;
    }

    @Override
    public String toString() {
        return "Fixinfo{" +
                "fixId=" + fixId +
                ", carId=" + carId +
                ", fixStarttime=" + fixStarttime +
                ", fixEndtime=" + fixEndtime +
                ", fixName='" + fixName + '\'' +
                ", fixMoney=" + fixMoney +
                '}';
    }
}

