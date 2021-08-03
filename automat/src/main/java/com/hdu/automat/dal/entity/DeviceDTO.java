package com.hdu.automat.dal.entity;

import lombok.Getter;
import lombok.Setter;
/**
 * (Device)实体类
 *
 * @author xjm
 * @since 2021-08-03 15:47:45
 */
@Setter
@Getter
public class DeviceDTO  {
    
    /**
    * 设备主键
    */
    private Long id;
    /**
    * 设备IP
    */
    private String deviceIp;
    /**
    * sim卡
    */
    private String simCardId;
    /**
    * 设备名称
    */
    private String deviceName;
    /**
    * 设备状态
    */
    private Integer status;
    /**
    * 设备地址
    */
    private String location;


}