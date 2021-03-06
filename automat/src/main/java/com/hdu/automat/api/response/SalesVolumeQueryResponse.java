package com.hdu.automat.api.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class SalesVolumeQueryResponse implements Serializable {

    private static final long serialVersionUID = -1462153535555040275L;
    // 每日销售额列表
    private List<String> salesVolumeList;

    // 总销售额
    private String totalSalesVolume;

}

