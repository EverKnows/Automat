package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class DeviceDeleteRequest implements Serializable {

    private static final long serialVersionUID = 1071479850661954821L;
    @NotNull(message = "设备ID不能为空")
    private Long deviceId;
}
