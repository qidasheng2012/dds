package com.it.common.utils;

import java.util.Calendar;

/**
 * Describe: 获取日期时间工具类
 */
public class DateUtil {

    /**
     * 获取年份
     * @return
     */
    public static int getYear() {

        Calendar cal = Calendar.getInstance();

        return  cal.get(Calendar.YEAR);
    }

    /**
     * 获取日期
     * @return
     */
    public static int getMonth() {
        Calendar cal = Calendar.getInstance();

        return  cal.get(Calendar.MONTH)+1;
    }

}
