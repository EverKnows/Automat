package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class DeviceReloadRequest implements Serializable {

    private static final long serialVersionUID = -5893964222201529083L;
    @NotNull(message = "设备ID不能为空")
    private Long deviceId;
}
