package com.hdu.automat.api.request;

import com.hdu.automat.biz.exception.ParamException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author jianmiao.xu
 * @date 2021/8/2
 */
@Setter
@Getter
public class OrderCreateRequest implements Serializable {

    private static final long serialVersionUID = 8703763825043787104L;

    private String location;

    private String itemName;

    // 设备simCardId
    private String simCardId;

    private Long deviceId;


    public void check() {
        if (StringUtils.isBlank(location)) {
            throw new ParamException("订单消费地点为空!");
        }

        if (StringUtils.isBlank(itemName)) {
            throw new ParamException("订单消费商品名称为空!");
        }

    }

}