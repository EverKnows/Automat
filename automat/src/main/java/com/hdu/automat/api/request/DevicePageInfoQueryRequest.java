package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DevicePageInfoQueryRequest implements Serializable {

    private static final long serialVersionUID = 2818019780735263756L;
    private Long pageNum = 1L;

    private Long pageSize = 10L;

}
