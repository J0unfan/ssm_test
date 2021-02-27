package com.itheima.ssm.dao;

import com.itheima.ssm.service.domian.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/27 21:11
 */
public interface IPermissionDao {

    /**
     * 根据角色id查找权限
     * @param roleId
     * @return
     */
    @Select(("select * from permission LEFT JOIN role_permission on " +
            "permission.id = role_permission.permissionId where role_permission.roleId = #{roleId}"))
    List<Permission> findByRoleId(String roleId);
}
