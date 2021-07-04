package com.hdu.automat.api.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ExceptionVo implements Serializable {

    // 设备Id
    private String deviceId;

    // 异常发生时间
    private String uploadDate;

    // 消费地点
    private String location;

    // 异常类型
    private String exceptionType;

    // 关联的通道
    private String channel;

    // 当前状态
    private String statusDesc;

    // 处理时间
    private String resolveDate;


}
