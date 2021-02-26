package com.itheima.ssm.dao;

import com.itheima.ssm.service.domian.UserInfo;
import org.apache.ibatis.annotations.Select;

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
    UserInfo findByUsername(String username);
}
