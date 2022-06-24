package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Materialtype)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@NoArgsConstructor
@AllArgsConstructor
public class Materialtype implements Serializable {
    private static final long serialVersionUID = -48995389916437357L;
    
    private Integer materialtypeId;
    
    private String materialtypeType;


    public Integer getMaterialtypeId() {
        return materialtypeId;
    }

    public void setMaterialtypeId(Integer materialtypeId) {
        this.materialtypeId = materialtypeId;
    }

    public String getMaterialtypeType() {
        return materialtypeType;
    }

    public void setMaterialtypeType(String materialtypeType) {
        this.materialtypeType = materialtypeType;
    }

    @Override
    public String toString() {
        return "Materialtype{" +
                "materialtypeId=" + materialtypeId +
                ", materialtypeType='" + materialtypeType + '\'' +
                '}';
    }
}

