package com.hdu.automat.biz.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    private String deviceId;

    // 设备名称
    private String deviceName;

    // 消费日期
    private String date;

    // 商品名称
    private String itemName;

    // 支付金额
    private String payAmount;

}