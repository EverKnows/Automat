package com.hdu.automat.api.request;

import com.hdu.automat.biz.exception.ParamException;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class SalesVolumeQueryRequest implements Serializable {

    // 开始日期  格式 yyyy-MM-dd 00:00:00
    @NotNull(message = "开始日期不能为空")
    private Date startDate;

    // 结束日期  格式 yyyy-MM-dd 00:00:00
    @NotNull(message = "结束日期不能为空")
    private Date endDate;


}
