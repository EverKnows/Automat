package com.hdu.automat.biz.repository;

import com.alibaba.fastjson.JSON;
import com.hdu.automat.biz.convert.OrderConvert;
import com.hdu.automat.biz.entity.OrderEntity;
import com.hdu.automat.biz.exception.ParamException;
import com.hdu.automat.biz.util.AssertUtil;
import com.hdu.automat.dal.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jianmiao.xu
 * @date 2021/8/2
 */
@Component
@Slf4j
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public void create(OrderEntity orderEntity) {
        AssertUtil.isTrue(orderEntity != null, "订单实体为空!");

        try {
            orderMapper.insert(OrderConvert.convert2DTO(orderEntity));
        } catch (Exception e) {
            log.error("OrderRepository::insert 插入订单信息失败, entity:{}, e:{}", JSON.toJSONString(orderEntity), e.getMessage());
            throw new ParamException(e.getMessage());
        }
    }
}