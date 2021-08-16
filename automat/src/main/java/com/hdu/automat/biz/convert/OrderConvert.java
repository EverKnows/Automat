package com.hdu.automat.biz.convert;

import com.google.common.collect.Lists;
import com.hdu.automat.biz.entity.OrderEntity;
import com.hdu.automat.biz.enums.OrderStatus;
import com.hdu.automat.dal.entity.OrderDTO;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jianmiao.xu
 * @date 2021/8/2
 */
public class OrderConvert {

    public static OrderEntity convert2Entity(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDTO.getId());
        orderEntity.setLocation(orderDTO.getLocation());
        orderEntity.setPayTime(orderDTO.getPayTime());
        orderEntity.setItemName(orderDTO.getItemName());
        orderEntity.setPayAmount(orderDTO.getPayAmount());
        orderEntity.setCreateTime(orderDTO.getCreateTime());
        orderEntity.setStatus(OrderStatus.getByCode(orderDTO.getStatus()));
        orderEntity.setOrderNo(orderDTO.getOrderNo());

        return orderEntity;
    }

    public static List<OrderEntity> convert2EntityList(List<OrderDTO> orderDTOList) {
        if (CollectionUtils.isEmpty(orderDTOList)) {
            return Lists.newArrayList();
        }

        return orderDTOList.stream().map(OrderConvert::convert2Entity).collect(Collectors.toList());
    }

    public static OrderDTO convert2DTO(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderEntity.getId());
        orderDTO.setOrderNo(orderEntity.getOrderNo());
        orderDTO.setLocation(orderEntity.getLocation());
        orderDTO.setDeviceId(orderEntity.getDeviceId());
        orderDTO.setCreateTime(orderEntity.getCreateTime());
        orderDTO.setPayTime(orderEntity.getPayTime());
        orderDTO.setItemName(orderEntity.getItemName());
        orderDTO.setPayAmount(orderEntity.getPayAmount());
        orderDTO.setStatus(orderEntity.getStatus().getCode());

        return orderDTO;
    }

}