package com.itheima.ssm.service.impl;

import com.itheima.ssm.service.IProductService;
import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.service.domian.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/22 22:18
 */
@Service("productService")
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements IProductService {

    @Resource
    private IProductDao iProductDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Product product) {
        String idStr = UUID.randomUUID().toString();
        product.setId(idStr.replace("-", ""));
        iProductDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return iProductDao.findAll();
    }
}
