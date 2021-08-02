package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class DeviceStatusModifyRequest implements Serializable {

    private static final long serialVersionUID = -1017229813225591033L;
    @NotNull(message = "状态不能为空")
    private Integer enable;

    @NotNull(message = "设备ID不能为空")
    private Long deviceId;
}
