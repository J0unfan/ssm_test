package com.itheima.ssm.service;

import com.itheima.ssm.service.domian.Product;

import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/22 22:15
 */
public interface IProductService {

    /**
     * 添加产品
     *
     * @param product
     */
    void save(Product product);

    /**
     * 查询所有产品
     * @return
     */
    List<Product> findAll();
}

