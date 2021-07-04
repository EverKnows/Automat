package com.hdu.automat.biz.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author jianmiao.xu
 * @date 2021/7/4
 */
@Setter
@Getter
public class DeviceAggregateRoot {


    private DeviceEntity deviceEntity;
}