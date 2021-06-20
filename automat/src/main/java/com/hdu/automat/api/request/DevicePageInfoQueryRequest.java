package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DevicePageInfoQueryRequest implements Serializable {

    private Long pageNum = 1L;

    private Long pageSize = 10L;

}
