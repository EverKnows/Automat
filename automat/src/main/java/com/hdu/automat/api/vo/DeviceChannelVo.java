package com.hdu.automat.api.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DeviceChannelVo implements Serializable {

    // 设备Id
    private Long deviceId;

    // 通道Id
    private Long channelId;

    // 通道名称
    private String channelName;

    // 商品Id
    private Long itemId;

    // 通道商品名称
    private String itemName;

    // 剩余量
    private Integer volume;

    // 货量描述  eg: 红豆薏米茶 10
    private String volumeDesc;
}
