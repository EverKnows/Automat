package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class DeviceReloadRequest implements Serializable {

    @NotNull(message = "设备ID不能为空")
    private Long deviceId;
}
