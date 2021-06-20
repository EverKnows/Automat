package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
public class OrderRefundRequest implements Serializable {

    @NotBlank(message = "订单编号不能为空")
    private String orderNo;

}
