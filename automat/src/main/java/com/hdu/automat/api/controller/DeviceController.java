package com.hdu.automat.api.controller;

import com.alibaba.fastjson.JSON;
import com.hdu.automat.api.request.DeviceStatusQueryRequest;
import com.hdu.automat.api.response.DeviceStatusQueryResponse;
import com.hdu.automat.api.response.HttpResult;
import com.hdu.automat.biz.enums.ItemInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @PostMapping("/sum")
    public String deviceStatusQuery(DeviceStatusQueryRequest request) {

        DeviceStatusQueryResponse response = new DeviceStatusQueryResponse();
        response.setSum(11L);

        return JSON.toJSONString(new HttpResult<DeviceStatusQueryResponse>().success(response));
    }


    @PostMapping("/item/query")
    public String itemQuery() {
        return JSON.toJSONString(new HttpResult<List<String>>().success(Arrays.stream(ItemInfo.values()).map(ItemInfo::getName).collect(Collectors.toList())));
    }




}
