package com.hdu.automat.api.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
public class OrderVo implements Serializable {

    // 订单号
    private String orderNo;

    // 消费地点
    private String location;

    // 消费日期
    private String date;

    // 商品名称
    private String itemName;

    // 支付金额
    private String payAmount;

}
