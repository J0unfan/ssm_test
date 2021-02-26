package com.itheima.ssm.dao;

import com.itheima.ssm.service.domian.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/22 22:11
 */
public interface IProductDao {

    /**
     * 根据产品id查询产品
     *
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    Product findById(String id);

    /**
     * 添加产品
     *
     * @param product
     */
    @Insert("insert into " +
            "product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 查询所有产品信息
     * @return List<Product>
     */
    @Select("select * from product")
    List<Product> findAll();
}
