package com.itheima.ssm.service.domian;

import lombok.Data;

import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/24 20:26
 */
@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
