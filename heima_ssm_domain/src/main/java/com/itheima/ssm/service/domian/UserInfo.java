package com.itheima.ssm.service.domian;

import lombok.Data;

import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/24 20:24
 */
@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;
}
