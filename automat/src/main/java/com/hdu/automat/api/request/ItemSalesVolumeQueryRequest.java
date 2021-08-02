package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class ItemSalesVolumeQueryRequest implements Serializable {

    private static final long serialVersionUID = -1903308463568864793L;
    // yyyy-MM
    @NotNull(message = "月份不能为空")
    private Date month;

}
