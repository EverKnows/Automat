package com.hdu.automat.api.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DeviceChannelVO implements Serializable {

    private static final long serialVersionUID = -1569445232906205191L;
    // 设备Id
    private Long deviceId;

    // 通道Id
    private Long channelId;

    // 通道名称
    private String channelName;

    // 通道商品名称
    private String itemName;

    // 货量描述  eg: 红豆薏米茶 10
    private String volumeDesc;
}
