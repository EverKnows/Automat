package com.hdu.automat.api.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class DeviceVO implements Serializable {

    // 设备Id
    private Long deviceId;

    // 设备IP
    private String deviceIp;

    // 设备名称
    private String deviceName;

    // 设备通道列表
    private List<DeviceChannelVo> channelVoList;

    // 状态描述
    private String statusDesc;

    // 机器状态 0 离线 1在线
    private Integer status;

    // 安装位置
    private String location;

}
