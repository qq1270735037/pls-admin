package com.cqu.pls.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MaterialAndType {
    private Integer materialId;

    private Integer materialtypeId;

    private String materialName;

    private Double materialPrice;

    private String materialUsage;

    private Integer materialCount;
    private String materialtypeType;

}
