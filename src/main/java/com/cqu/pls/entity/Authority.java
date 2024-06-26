package com.cqu.pls.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Authority)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements Serializable {
    private static final long serialVersionUID = 495104037348900846L;
    
    private Integer authorityId;
    
    private String authorityName;


    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authorityId=" + authorityId +
                ", authorityName='" + authorityName + '\'' +
                '}';
    }
}

