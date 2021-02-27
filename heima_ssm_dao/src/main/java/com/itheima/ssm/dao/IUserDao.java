package com.itheima.ssm.dao;

import com.itheima.ssm.service.domian.Role;
import com.itheima.ssm.service.domian.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import javax.rmi.PortableRemoteObject;
import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/26 10:57
 */
public interface IUserDao {

    /**
     * 根据username查询user
     *
     * @param username
     * @return
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username);

    /**
     * findById
     * @param userId
     * @return
     */
    @Select("select * from users where id = #{userId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String userId);

    /**
     * 根据userId查询用户未拥有的角色
     * @param userId
     * @return
     */
    @Select("select * from role where role.id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll();

    /**
     * 为用户添加角色
     * @param userId
     * @param roleId
     */
    @Insert("insert into users_role(userId,roleId) value(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
