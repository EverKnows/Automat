package com.hdu.automat.biz.util;

import java.math.BigDecimal;

/**
 * @author jianmiao.xu
 * @date 2021/8/6
 */
public class MoneyUtil {

    public static double cent2Yuan(Long cent) {
        AssertUtil.isTrue(cent != null && cent >= 0, "金额不合法");

        BigDecimal bigDecimal = new BigDecimal(cent).movePointLeft(2);

        return bigDecimal.doubleValue();
    }

}