package com.hdu.automat.biz.repository;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.hdu.automat.biz.convert.OrderConvert;
import com.hdu.automat.biz.entity.OrderEntity;
import com.hdu.automat.biz.enums.OrderStatus;
import com.hdu.automat.biz.exception.ParamException;
import com.hdu.automat.biz.util.AssertUtil;
import com.hdu.automat.dal.entity.OrderDTO;
import com.hdu.automat.dal.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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


    public List<OrderEntity> queryByTimeAndStatus(Date beginTime, Date endTime, List<OrderStatus> orderStatusList) {
        return  OrderConvert.convert2EntityList(orderMapper.loadByTime(beginTime, endTime, orderStatusList.stream()
                                                                                                          .map(OrderStatus::getCode)
                                                                                                          .distinct()
                                                                                                          .collect(Collectors.toList())));
    }


    public PageInfo<OrderEntity> pageQueryByTimeAndStatus(Date beginTime, Date endTime,
                                                          List<OrderStatus> orderStatusList,
                                                          Integer pageNum,
                                                          Integer pageSize) {

        AssertUtil.isTrue(pageNum != null, "页码不能为空!");
        AssertUtil.isTrue(pageSize != null, "页大小不能为空!");

        PageHelper.startPage(pageNum, pageSize, false);
        List<OrderDTO> orderDTOList = orderMapper.loadByTime(beginTime, endTime, orderStatusList.stream()
                                                                                                .map(OrderStatus::getCode)
                                                                                                .distinct()
                                                                                                .collect(Collectors.toList()));
        return new PageInfo<>(OrderConvert.convert2EntityList(orderDTOList));
    }
}