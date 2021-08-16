package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class OrderQueryRequest implements Serializable {

    private static final long serialVersionUID = 6132552793172184473L;
    @NotNull(message = "开始日期不能为空")
    private String startDate;

    @NotNull(message = "结束日期不能为空")
    private String endDate;

    @NotNull(message = "订单状态不能为空")
    private Integer orderStatus;

    private Integer pageNum = 1;

    private Integer pageSize = 10;
}
