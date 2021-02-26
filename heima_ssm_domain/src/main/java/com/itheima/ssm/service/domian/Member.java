package com.itheima.ssm.service.domian;

import lombok.Data;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/24 15:13
 */
@Data
public class Member {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}
