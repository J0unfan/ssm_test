package com.itheima.ssm.service.domian;

import lombok.Data;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/24 15:14
 */
@Data
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;
}
