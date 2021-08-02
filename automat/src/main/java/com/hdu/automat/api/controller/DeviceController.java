package com.hdu.automat.api.controller;

import com.hdu.automat.api.request.DeviceStatusQueryRequest;
import com.hdu.automat.api.response.DeviceStatusQueryResponse;
import com.hdu.automat.api.response.HttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceController {

    @RequestMapping(value = "/sum")
    @ResponseBody
    public HttpResult<DeviceStatusQueryResponse> deviceStatusQuery(DeviceStatusQueryRequest request) {

        System.out.println("start routing");
        DeviceStatusQueryResponse response = new DeviceStatusQueryResponse();
        response.setSum(11L);

        return new HttpResult<DeviceStatusQueryResponse>().success(response);
    }


    @RequestMapping(value = "/item/query")
    @ResponseBody
    public String itemQuery() {
        //return JSON.toJSONString(new HttpResult<List<String>>().success(Arrays.stream(ItemInfo.values()).map(ItemInfo::get).collect(Collectors.toList())));
        return "123";
    }

    


}
