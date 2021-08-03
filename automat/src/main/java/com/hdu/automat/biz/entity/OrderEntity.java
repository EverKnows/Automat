package com.hdu.automat.biz.entity;

import com.hdu.automat.biz.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author jianmiao.xu
 * @date 2021/7/4
 */
@Setter
@Getter
public class OrderEntity {

    private Long id;

    // 订单号
    private String orderNo;

    // 消费地点
    private String location;

    // 设备ID
    private Long deviceId;

    // 设备名称
    //private String deviceName;

    // 消费日期
    private Date createTime;

    // 支付时间
    private Date payTime;

    // 商品名称
    private String itemName;

    // 支付金额
    private Long payAmount;

    // 订单状态
    private OrderStatus status;

}