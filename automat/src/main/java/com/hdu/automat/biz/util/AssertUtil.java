package com.hdu.automat.biz.util;

import com.hdu.automat.biz.exception.ParamException;

/**
 * @author jianmiao.xu
 * @date 2021/7/30
 */
public class AssertUtil {

    public static void isTrue(boolean expression, String msg) {
        if (!expression) {
            throw new ParamException(msg);
        }
    }
}