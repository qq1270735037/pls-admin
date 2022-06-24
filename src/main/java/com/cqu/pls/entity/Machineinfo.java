package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Machineinfo)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@NoArgsConstructor
@AllArgsConstructor
public class Machineinfo implements Serializable {
    private static final long serialVersionUID = -82290293077909540L;
    
    private Integer machineId;
    
    private String machineName;
    
    private String machineType;
    
    private Integer machineYear;
    
    private Double machinePower;


    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public Integer getMachineYear() {
        return machineYear;
    }

    public void setMachineYear(Integer machineYear) {
        this.machineYear = machineYear;
    }

    public Double getMachinePower() {
        return machinePower;
    }

    public void setMachinePower(Double machinePower) {
        this.machinePower = machinePower;
    }

    @Override
    public String toString() {
        return "Machineinfo{" +
                "machineId=" + machineId +
                ", machineName='" + machineName + '\'' +
                ", machineType='" + machineType + '\'' +
                ", machineYear=" + machineYear +
                ", machinePower=" + machinePower +
                '}';
    }
}

