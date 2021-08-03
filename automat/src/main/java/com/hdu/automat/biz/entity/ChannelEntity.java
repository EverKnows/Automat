package com.hdu.automat.biz.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jianmiao.xu
 * @date 2021/7/4
 */
@Setter
@Getter
public class ChannelEntity {

    public String id;

    private Integer subId;

    private String deviceId;

    private String itemName;

    private String price;

    private Long size;

    private Long stock;
}