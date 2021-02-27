package com.itheima.ssm.dao;

import com.itheima.ssm.service.domian.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/26 20:22
 */
public interface IRoleDao {

    /**
     * 根据userId查询角色
     *
     * @param userId
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleName",property="roleName"),
            @Result(column="roleDesc",property="roleDesc"),
            @Result(column="id",property="permissions",javaType=List.class,many=@Many(select="com.itheima.ssm"+
                    ".dao.IPermissionDao.findByRoleId"))
    })
    List<Role> findRoleByUserId(String userId);
}
