package com.hdu.automat.biz.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hdu.automat.api.vo.DeviceChannelVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author jianmiao.xu
 * @date 2021/7/4
 */
@Setter
@Getter
public class DeviceEntity {
    // 设备Id
    private Long deviceId;

    // 设备IP
    private String deviceIp;

    // sim卡ID
    private String simCardId;

    // 设备名称
    private String deviceName;

    // 设备通道列表
    private List<ChannelEntity> channelVoList;

    // 状态描述
    private String statusDesc;

    private String channelVoJson;

    // 安装位置
    private String location;

    public void convert2List() {
        this.channelVoList = JSONArray.parseArray(this.channelVoJson, ChannelEntity.class);
    }
}