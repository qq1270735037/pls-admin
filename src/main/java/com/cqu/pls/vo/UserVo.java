package com.cqu.pls.vo;

import lombok.Data;

@Data
public class UserVo {
    //用户账号
    private String userId;
    //用户类型
    private String authorityName;
    //用户名称
    private String userName;
}
