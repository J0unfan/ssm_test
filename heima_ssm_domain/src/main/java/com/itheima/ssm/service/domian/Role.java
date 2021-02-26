package com.itheima.ssm.service.domian;

import lombok.Data;

import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/24 20:25
 */
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> users;
}
