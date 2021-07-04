package com.hdu.automat.api.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DeviceStatusQueryResponse implements Serializable {

    private static final long serialVersionUID = -5427367202360716060L;
    private Long sum;
}
