package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.service.IOrdersService;
import com.itheima.ssm.service.domian.Orders;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/23 22:34
 */
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Resource
    private IOrdersDao ordersDao;

    /**
     * 分页查询所有订单
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Orders> findAll(int page, int size) {
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }
}
