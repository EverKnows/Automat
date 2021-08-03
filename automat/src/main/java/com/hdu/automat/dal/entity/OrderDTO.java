package com.hdu.automat.dal.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
/**
 * (Order)实体类
 *
 * @author xjm
 * @since 2021-08-02 14:25:58
 */
@Setter
@Getter
public class OrderDTO  {
    
    /**
    * 主键

    */
    private Long id;
    /**
    * 消费地点
    */
    private String location;
    /**
    * 支付时间
    */
    private Date payTime;
    /**
    * 商品名称

    */
    private String itemName;
    /**
    * 支付金额
    */
    private Long payAmount;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 订单状态
    */
    private Integer status;
    /**
    * 订单号
    */
    private String orderNo;

    /**
     * 设备ID
     */
    private Long deviceId;


}