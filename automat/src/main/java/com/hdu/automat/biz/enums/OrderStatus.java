package com.hdu.automat.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jianmiao.xu
 * @date 2021/8/2
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {

    WAITING_PAY(0, "待支付"),
    PAYING(1, "支付中"),
    PAIED(2, "已支付"),
    CANCLED(3, "已取消");

    private final int code;

    private final String desc;

    public static OrderStatus getByCode(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }
}
