package com.hdu.automat.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jianmiao.xu
 * @date 2021/8/3
 */
@Getter
@AllArgsConstructor
public enum DeviceStatus {

    INIT(0, "初始化"),
    RUNNING(1, "运行中"),
    ERROR(-1, "故障"),;

    private final int code;

    private final String desc;

    public static DeviceStatus getByCode(int code) {
        for (DeviceStatus value : DeviceStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }

        return null;
    }
}