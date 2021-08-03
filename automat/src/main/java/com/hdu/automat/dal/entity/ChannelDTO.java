package com.hdu.automat.dal.entity;

import lombok.Getter;
import lombok.Setter;
/**
 * (Channel)实体类
 *
 * @author xjm
 * @since 2021-08-03 15:47:35
 */
@Setter
@Getter
public class ChannelDTO  {
    
    /**
    * 主键Id
    */
    private Long id;
    /**
    * 渠道子Id
    */
    private Integer subId;
    /**
    * 设备ID
    */
    private Long deviceId;
    /**
    * 商品名称

    */
    private String itemName;
    /**
    * 价格
    */
    private Long price;
    /**
    * 通道最大容量
    */
    private Long size;
    /**
    * 通道商品存量
    */
    private Long stock;


}