package com.hdu.automat.biz.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParamException extends RuntimeException{

    private String msg;

    public ParamException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
