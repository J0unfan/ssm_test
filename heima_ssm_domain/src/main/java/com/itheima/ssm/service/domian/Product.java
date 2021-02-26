package com.itheima.ssm.service.domian;

import com.itheima.ssm.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author Ljunfan
 * @description 商品信息
 * @date 2021/2/22 21:55
 */
@Data
public class Product {
    /**
     * 主键id
     */
    private String id;
    /**
     * 编号 唯一
     */
    private String productNum;
    /**
     * 名称
     */
    private String productName;
    /**
     * 出发城市
     */
    private String cityName;
    /**
     * 出发时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;

    private String departureTimeStr;
    /**
     * 产品价格
     */
    private BigDecimal productPrice;
    /**
     * 产品描述
     */
    private String productDesc;
    /**
     * 状态 0 关闭 1 开启
     */
    private Integer productStatus;

    private String productStatusStr;

    public String getDepartureTimeStr() {
        if (Objects.nonNull(departureTime)) {
            departureTimeStr = DateUtils.date3String(departureTime, "yyyy-MM-dd HH:mm:ss");
        }

        return departureTimeStr;
    }

    public String getProductStatusStr() {
        if (Objects.nonNull(productStatus)) {
            if (productStatus == 0) {
                productStatusStr = "关闭";
            }if (productStatus == 1) {
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }
}
