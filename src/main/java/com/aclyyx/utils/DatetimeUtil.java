package com.aclyyx.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 工具类,时间工具
 * 版本:v0.1
 * Created by aclyyx on 16/5/17.
 */
public class DatetimeUtil {

    private static DatetimeUtil util;
    //private SimpleDateFormat dfhh24mmss;
    private SimpleDateFormat dfDateTime;
    private DecimalFormat nf00;

    private DatetimeUtil() {
        reset();
    }

    /**
     * 获取工具单例对象
     * @return
     */
    public static DatetimeUtil newInstance() {
        if (util == null) {
            util = new DatetimeUtil();
        }
        return util;
    }

    /**
     * 当系统时间在应用运行时被改变, 需要调用此方法, 否则格式化后的时间可能出现问题
     */
    public void reset() {
        //dfhh24mmss  = new SimpleDateFormat("HH:mm:ss");
        dfDateTime  = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        nf00        = new DecimalFormat("00");
    }

    /**
     * 对传入的long型数据, 格式化为 hh:mm:ss 并返回, 主要对于倒计时等使用
     * @param l long型时间间隔参数, 单位:毫秒
     * @return 如果时间超过1小时,则显示小时数据(hh:mm:ss);如果时间在1小时以内,则不显示小时数,仅显示分和秒(mm:ss)
     */
    public String long_2_HHmmss(long l) {
        l = l / 1000;
        int h = Long.valueOf(l / 3600).intValue();
        int m = Long.valueOf(l % 3600 / 60).intValue();
        int s = Long.valueOf(l % 60).intValue();
        return (h > 0 ? (nf00.format(h) + ":") : "") + nf00.format(m) + ":" + nf00.format(s);
    }

    /**
     * 对传入的long型数据, 格式化为 yyyy-MM-dd HH:mm 并返回
     * @param l long型时间参数, 单位:毫秒
     * @return yyyy-MM-dd HH:mm
     */
    public String long_2_YYYYMMDD_HHmm(long l) {
        return dfDateTime.format(new Date(l));
    }

    public final static String[] WEEK_DAYS = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    /**
     * 对传入的long型数据, 格式化为 周X 并返回
     * @param l long型时间参数, 单位:毫秒
     * @return 周X, 如: 周日,周一等
     */
    public String long_2_DayOfTheWeek(long l) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(l);
        int w = c.get(Calendar.DAY_OF_WEEK) - 1;
        String x = WEEK_DAYS[w];
        return x;
    }
}
