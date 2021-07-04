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

    private String deviceId;

    private String deviceName;

    private String itemName;

    private String price;

    private Integer num;
}