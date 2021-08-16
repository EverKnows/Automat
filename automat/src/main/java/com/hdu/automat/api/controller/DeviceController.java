package com.hdu.automat.api.controller;

import com.alibaba.fastjson.JSON;
import com.hdu.automat.api.request.DeviceRegistryRequest;
import com.hdu.automat.api.request.DeviceStatusQueryRequest;
import com.hdu.automat.api.response.DeviceStatusQueryResponse;
import com.hdu.automat.api.response.HttpResult;
import com.hdu.automat.biz.entity.DeviceEntity;
import com.hdu.automat.biz.enums.DeviceStatus;
import com.hdu.automat.biz.repository.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class DeviceController {

    @Resource
    private DeviceService deviceService;

    @RequestMapping(value = "/device/delete")
    public HttpResult<DeviceStatusQueryResponse> deviceStatusQuery(@RequestBody DeviceStatusQueryRequest request) {
        log.info("OrderController::create 创建订单, request:{}", JSON.toJSONString(request));
        System.out.println("start routing");
        DeviceStatusQueryResponse response = new DeviceStatusQueryResponse();
        response.setSum(11L);

        return new HttpResult<DeviceStatusQueryResponse>().success(response);
    }


    @RequestMapping(value = "/device/registry")
    public HttpResult<Boolean> registry(@RequestBody DeviceRegistryRequest request) {

        log.info("DeviceController::registry 开始注册新机器, request:{}", JSON.toJSONString(request));

        try {

            DeviceEntity deviceEntity = new DeviceEntity();
            deviceEntity.setDeviceIp(request.getDeviceIp());
            deviceEntity.setDeviceName(request.getDeviceName());
            deviceEntity.setLocation(request.getLocation());
            deviceEntity.setSimCardId(request.getSimCardId());
            deviceEntity.setStatus(DeviceStatus.INIT);

            deviceService.registry(deviceEntity);

        } catch (Exception e) {
            log.error("DeviceController::registry 注册新机器失败, request:{}, e:{}", JSON.toJSONString(request), e.getMessage());
            return new HttpResult<Boolean>().fail(e.getMessage());
        }

        log.info("DeviceController::registry 注册新机器成功, request:{}, ", JSON.toJSONString(request));

        return new HttpResult<Boolean>().success(Boolean.TRUE);
    }

    


}
