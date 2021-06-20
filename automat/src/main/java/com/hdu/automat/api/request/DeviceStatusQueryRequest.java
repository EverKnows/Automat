package com.hdu.automat.api.request;

import com.hdu.automat.biz.exception.ParamException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class DeviceStatusQueryRequest implements Serializable {

    // 设备状态查询 0 离线 1 在线 2 全部
    @NotNull(message = "机器在线状态不能为空")
    private Integer enable;

}
