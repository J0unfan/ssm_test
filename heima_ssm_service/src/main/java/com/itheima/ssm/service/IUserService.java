package com.itheima.ssm.service;

import com.itheima.ssm.service.domian.Role;
import com.itheima.ssm.service.domian.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/26 10:50
 */
public interface IUserService extends UserDetailsService {

    /**
     * findById
     * @param userId
     * @return
     */
    UserInfo findById(String userId);

    /**
     * 查询用户未拥有的角色list
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId);

    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 添加用户-角色信息
     * @param userId
     * @param roles
     */
    void addRoleToUser(String userId, List<String> roles);
}
