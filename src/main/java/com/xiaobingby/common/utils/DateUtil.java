package com.xiaobingby.common.utils;

import java.util.Calendar;

/**
 * Author: XiaoBingBy
 * Email: XiaoBingBy@qq.com
 * Date: 2017/9/1
 * Time: 00:00
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
