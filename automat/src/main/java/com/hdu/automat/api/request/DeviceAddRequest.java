package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
public class DeviceAddRequest implements Serializable {

    private static final long serialVersionUID = 2058166566473534592L;
    // 设备名称
    @NotBlank(message = "设备名称不能为空")
    private String deviceName;

    // 设备IP
    @NotBlank(message = "设备IP不能为空")
    private String deviceIp;

    @NotBlank(message = "sim卡号")
    private String simCardId;

    // 设备安装地
    @NotBlank(message = "安装地不能为空")
    private String location;
}
