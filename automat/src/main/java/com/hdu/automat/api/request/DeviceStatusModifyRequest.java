package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class DeviceStatusModifyRequest implements Serializable {

    @NotNull(message = "状态不能为空")
    private Integer enable;

    @NotNull(message = "设备ID不能为空")
    private Long deviceId;
}
