package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/23 14:02
 */
public class DateUtils {

    /**
     * 日期转换成字符串
     * @param date
     * @param patt
     * @return
     */
    public static String date3String(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);

        return format;
    }

    /**
     * 字符串转换成日期
     * @param str
     * @param patt
     * @return
     * @throws ParseException
     */
    public static Date string2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date parse = sdf.parse(patt);

        return parse;
    }
}
