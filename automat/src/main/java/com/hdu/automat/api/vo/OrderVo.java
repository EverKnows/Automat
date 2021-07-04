package com.hdu.automat.api.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
public class OrderVo implements Serializable {

    private static final long serialVersionUID = -2168644102201311847L;
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
