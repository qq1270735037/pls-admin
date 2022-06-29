package com.cqu.pls.vo;

import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.entity.Buildinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//public class BuildAndAddress implements Serializable  {
//    private Buildinfo buildinfo;
//    private Addressinfo addressinfo;
//}

public class BuildAndAddress {
    private Integer addressId;

    private String addressProvince;

    private String addressCity;

    private String addressName;
    private Integer buildId;


    private String bulidName;

    private String buildStyle;

    private Integer buildRent;

    private Integer buildArea;

    private String buildPerson;
}
