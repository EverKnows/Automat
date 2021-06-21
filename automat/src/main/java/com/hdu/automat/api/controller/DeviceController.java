package com.hdu.automat.api.controller;

import com.alibaba.fastjson.JSON;
import com.hdu.automat.api.request.DeviceStatusQueryRequest;
import com.hdu.automat.api.response.DeviceStatusQueryResponse;
import com.hdu.automat.api.response.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @PostMapping("/sum")
    public String deviceStatusQuery(DeviceStatusQueryRequest request) {

        DeviceStatusQueryResponse response = new DeviceStatusQueryResponse();
        response.setSum(11L);

        return JSON.toJSONString(new HttpResult<DeviceStatusQueryResponse>().success(response));
    }


}
