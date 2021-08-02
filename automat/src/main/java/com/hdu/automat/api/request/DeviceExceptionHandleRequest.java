package com.hdu.automat.api.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DeviceExceptionHandleRequest implements Serializable {

    private static final long serialVersionUID = -1668813726175837531L;
    private Long id;
}
