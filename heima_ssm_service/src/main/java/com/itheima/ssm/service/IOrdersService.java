package com.itheima.ssm.service;

import com.itheima.ssm.service.domian.Orders;

import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/23 22:34
 */
public interface IOrdersService {
    /**
     * 分页查询所有订单
     *
     * @param page
     * @param size
     * @return
     */
    List<Orders> findAll(int page, int size);
}
