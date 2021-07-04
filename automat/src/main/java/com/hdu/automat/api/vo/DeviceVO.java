package com.hdu.automat.api.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class DeviceVO implements Serializable {

    private static final long serialVersionUID = 8439988597342457305L;
    // 设备Id
    private Long deviceId;

    // 设备IP
    private String deviceIp;

    // sim卡ID
    private String simCardId;

    // 设备名称
    private String deviceName;

    // 设备通道列表
    private List<DeviceChannelVo> channelVoList;

    // 状态描述
    private String statusDesc;

    // 安装位置
    private String location;

}
