package com.itheima.ssm.service.domian;

import com.itheima.ssm.utils.DateUtils;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/23 22:12
 */
@Data
public class Orders {

    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getOrderTimeStr() {
        if (Objects.nonNull(orderTime)) {
            orderTimeStr = DateUtils.date3String(orderTime, "yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public String getOrderStatusStr() {
        if (orderStatus == 0) {
            orderStatusStr = "未支付";
        }else if (orderStatus == 1) {
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public String getPayTypeStr() {
        if (payType == 0) {
            payTypeStr = "支付宝";
        }else if (payType == 1) {
            payTypeStr = "微信";
        }else if (payType == 2) {
            payTypeStr = "其他";
        }
        return payTypeStr;
    }
}
