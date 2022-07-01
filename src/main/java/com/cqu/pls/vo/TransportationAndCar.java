package com.cqu.pls.vo;

import com.cqu.pls.entity.Transportationinfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heinideyibadiaole
 * @create 2022-06-30 10:01
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransportationAndCar implements Serializable {
    private static final long serialVersionUID = -73190779263642338L;

    private Long transportationId;

    private Integer carId;

    private String carNumber;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date transportationStartTime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date transportationEndTime;

    private String transportationStartLocation;

    private String transportationEndLocation;

    private String transportationMoney;



}
