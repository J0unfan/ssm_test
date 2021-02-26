package com.itheima.ssm.controller;

import com.itheima.ssm.service.IProductService;
import com.itheima.ssm.service.domian.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/23 10:17
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService iProductService;

    /**
     * 添加产品
     *
     * @param product
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Product product){
        iProductService.save(product);

        return "redirect:findAll.do";
    }

    /**
     * 查询所有产品信息
     *
     * @return 产品信息
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Product> products = iProductService.findAll();
        mv.addObject("productList", products);
        mv.setViewName("product-list");

        return mv;
    }
}
