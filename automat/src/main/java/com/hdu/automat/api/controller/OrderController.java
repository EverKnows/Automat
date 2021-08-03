package com.hdu.automat.api.controller;

import com.alibaba.fastjson.JSON;
import com.hdu.automat.api.request.OrderCreateRequest;
import com.hdu.automat.api.response.HttpResult;
import com.hdu.automat.api.vo.OrderVO;
import com.hdu.automat.biz.entity.OrderEntity;
import com.hdu.automat.biz.enums.OrderStatus;
import com.hdu.automat.biz.repository.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jianmiao.xu
 * @date 2021/8/2
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/order/create")
    public HttpResult<OrderVO> create(OrderCreateRequest request) {

        log.info("OrderController::create 创建订单, request={}", JSON.toJSONString(request));
        try {
            request.check();

            // 获取设备对应的ID todo
            Long deviceId = 1111L;

            OrderEntity entity = new OrderEntity();
            entity.setStatus(OrderStatus.WAITING_PAY);
            entity.setDeviceId(deviceId);
            entity.setLocation();

            orderService.create();

        } catch (Exception e) {
            log.error("OrderController::create 创建订单失败, request={}, e={}", JSON.toJSONString(request), e.getMessage());
            return new HttpResult<OrderVO>().fail("创建订单失败, 请稍后再试!");
        }

        return new HttpResult<OrderVO>().success();
    }
}