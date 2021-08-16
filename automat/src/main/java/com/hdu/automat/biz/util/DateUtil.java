package com.hdu.automat.biz.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.datetime.joda.LocalDateParser;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author jianmiao.xu
 * @date 2021/8/6
 */
public class DateUtil {

    public static final String yyyyMMddhhmmss = "yyyy-MM-dd hh:mm:ss";

    public static Date convert(String date) {
        AssertUtil.isTrue(StringUtils.isNotBlank(date), "日期不合法!");

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(yyyyMMddhhmmss));

        return Date.from(localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
    }

    public static String convert(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(yyyyMMddhhmmss);
        return formatter.format(date);
    }
}