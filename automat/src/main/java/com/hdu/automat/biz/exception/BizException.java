package com.hdu.automat.biz.exception;

/**
 * @author jianmiao.xu
 * @date 2021/8/3
 */
public class BizException extends RuntimeException{

    private static final long serialVersionUID = 2747812469542275833L;

    private String msg;

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }
}