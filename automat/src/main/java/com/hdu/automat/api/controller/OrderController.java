package com.hdu.automat.api.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.hdu.automat.api.request.OrderCreateRequest;
import com.hdu.automat.api.request.OrderQueryRequest;
import com.hdu.automat.api.response.HttpResult;
import com.hdu.automat.api.vo.OrderVO;
import com.hdu.automat.biz.entity.DeviceEntity;
import com.hdu.automat.biz.entity.OrderEntity;
import com.hdu.automat.biz.enums.OrderStatus;
import com.hdu.automat.biz.repository.OrderService;
import com.hdu.automat.biz.util.DateUtil;
import com.hdu.automat.biz.util.MoneyUtil;
import com.hdu.automat.dal.entity.DeviceDTO;
import com.hdu.automat.dal.entity.OrderDTO;
import com.hdu.automat.dal.mapper.DeviceMapper;
import com.hdu.automat.dal.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jianmiao.xu
 * @date 2021/8/2
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private DeviceMapper deviceMapper;

    @RequestMapping(value = "/order/create")
    public HttpResult<OrderVO> create(@RequestBody OrderCreateRequest request) {

        log.info("OrderController::create 创建订单, request={}", JSON.toJSONString(request));
        try {
            request.check();

            OrderEntity entity = new OrderEntity();
            entity.setStatus(OrderStatus.WAITING_PAY);
            entity.setDeviceId(request.getDeviceId());
            entity.setLocation(request.getLocation());

            orderService.create(entity);

        } catch (Exception e) {
            log.error("OrderController::create 创建订单失败, request={}, e={}", JSON.toJSONString(request), e.getMessage());
            return new HttpResult<OrderVO>().fail("创建订单失败, 请稍后再试!");
        }

        return new HttpResult<OrderVO>().success(null);
    }

    @RequestMapping(value = "/order/sum")
    public HttpResult<String> sum(@RequestBody OrderQueryRequest request) {

        log.info("OrderController::sum 根据时间范围查找订单营业额, request:{}", JSON.toJSONString(request));

        StringBuilder result = new StringBuilder();

        try {
            List<OrderEntity> orderEntityList = orderService.queryByTimeAndStatus(
                    DateUtil.convert(request.getStartDate()), DateUtil.convert(request.getEndDate()),
                    Lists.newArrayList(OrderStatus.PAIED));

            double money = MoneyUtil.cent2Yuan(orderEntityList.stream().mapToLong(OrderEntity::getPayAmount).sum());

            result.append(money).append("元");
        } catch (Exception e) {
            log.error("OrderController::sum 获取指定范围内营业额失败, request:{}, e:{}", JSON.toJSONString(request),
                      e.getMessage());

            return new HttpResult<String>().fail(e.getMessage());
        }
        return new HttpResult<String>().success(result.toString());
    }

    @RequestMapping(value = "/order/query")
    public HttpResult<List<OrderVO>> query(@RequestBody OrderQueryRequest request) {

        log.info("OrderController::query 根据时间范围查找订单 request:{}", JSON.toJSONString(request));

        List<OrderVO> voList = Lists.newArrayList();

        try {
            List<OrderEntity> orderEntityList = orderService.queryByTimeAndStatus(
                    DateUtil.convert(request.getStartDate()), DateUtil.convert(request.getEndDate()),
                    Lists.newArrayList(OrderStatus.PAIED));

            List<DeviceDTO> deviceDTOList = deviceMapper.batchLoadById(orderEntityList.stream().map(OrderEntity::getDeviceId).distinct().collect(
                    Collectors.toList()));

            Map<Long, DeviceDTO> deviceDTOMap = deviceDTOList.stream()
                                                             .collect(Collectors.toMap(DeviceDTO::getId, dto -> dto, (newOne, oldOne) -> newOne));

            voList = CollectionUtils.isEmpty(orderEntityList) ? Lists.newArrayList() :
                    orderEntityList.stream().map(entity -> {

                        DeviceDTO deviceDTO = deviceDTOMap.get(entity.getDeviceId());
                        OrderVO vo = new OrderVO();
                        vo.setDate(DateUtil.convert(entity.getPayTime()));
                        vo.setDeviceId(String.valueOf(entity.getDeviceId()));
                        vo.setDeviceName(deviceDTO.getDeviceName());
                        vo.setItemName(entity.getItemName());
                        vo.setLocation(deviceDTO.getLocation());
                        vo.setOrderNo(entity.getOrderNo());
                        vo.setPayAmount(String.valueOf(MoneyUtil.cent2Yuan(entity.getPayAmount())));

                        return vo;
                    }).collect(Collectors.toList());

        } catch (Exception e) {
            log.error("OrderController::sum 获取指定范围内营业额失败, request:{}, e:{}", JSON.toJSONString(request),
                      e.getMessage());

            return new HttpResult<List<OrderVO>>().fail(e.getMessage());
        }
        return new HttpResult<List<OrderVO>>().success(voList);
    }

    @RequestMapping(value = "/order/pageQuery")
    public HttpResult<List<OrderVO>> pageQuery(@RequestBody OrderQueryRequest request) {

        log.info("OrderController::pageQuery 开始分页查询订单信息, request:{}", JSON.toJSONString(request));

        HttpResult<List<OrderVO>> httpResult = new HttpResult<>();

        List<OrderStatus> orderStatusList = Lists.newArrayList(OrderStatus.values());

        try {
            PageInfo<OrderEntity> pageInfo = orderService.pageQueryByTimeAndStatus(DateUtil.convert(request.getStartDate()),
                                                                                    DateUtil.convert(request.getEndDate()),
                                                                                    orderStatusList,
                                                                                    request.getPageNum(),
                                                                                    request.getPageSize());

            if (!CollectionUtils.isEmpty(pageInfo.getList())) {
                List<DeviceDTO> deviceDTOList = deviceMapper.batchLoadById(pageInfo.getList().stream().map(OrderEntity::getDeviceId).distinct().collect(
                        Collectors.toList()));

                Map<Long, DeviceDTO> deviceDTOMap = deviceDTOList.stream()
                                                                 .collect(Collectors.toMap(DeviceDTO::getId, dto -> dto, (newOne, oldOne) -> newOne));

                List<OrderVO> voList = CollectionUtils.isEmpty(pageInfo.getList()) ? Lists.newArrayList() :
                        pageInfo.getList().stream().map(entity -> {

                            DeviceDTO deviceDTO = deviceDTOMap.get(entity.getDeviceId());
                            OrderVO vo = new OrderVO();
                            vo.setDate(DateUtil.convert(entity.getPayTime()));
                            vo.setDeviceId(String.valueOf(entity.getDeviceId()));
                            vo.setDeviceName(deviceDTO.getDeviceName());
                            vo.setItemName(entity.getItemName());
                            vo.setLocation(deviceDTO.getLocation());
                            vo.setOrderNo(entity.getOrderNo());
                            vo.setPayAmount(String.valueOf(MoneyUtil.cent2Yuan(entity.getPayAmount())));

                            return vo;
                        }).collect(Collectors.toList());

                httpResult.setData(voList);
            }

            httpResult.setCode(HttpResult.SUCCESS);
            httpResult.setPageNum(pageInfo.getPageNum());
            httpResult.setPageSize(pageInfo.getPageSize());
            httpResult.setCurPage(pageInfo.getPageNum());
            httpResult.setPages(pageInfo.getPages());
            httpResult.setTotal(pageInfo.getTotal());

        } catch (Exception e) {
            log.error("OrderController::pageQuery 分页查询失败, request:{}, e:{}", JSON.toJSONString(request), e.getMessage());
            return new HttpResult<List<OrderVO>>().fail(e.getMessage());
        }

        log.info("OrderController::pageQuery 订单分页查询成功, request:{}, result:{}", JSON.toJSONString(request), JSON.toJSONString(httpResult));

        return httpResult;
    }
}