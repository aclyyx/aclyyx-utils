package com.aclyyx.utils;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aclyyx on 16/5/17.
 */
public class DatetimeUtilTest extends TestCase {

    private DatetimeUtil util;

    @Override
    protected void setUp() throws Exception {
        util = DatetimeUtil.newInstance();
    }

    public void testLong_2_HHmmss1() {
        long l = (10*3600 + 15*60 + 10) * 1000;
        String string = util.long_2_HHmmss(l);
        Assert.assertEquals("10:15:10", string);
    }
    public void testLong_2_HHmmss2() {
        long l = 10*1000;
        String string = util.long_2_HHmmss(l);
        Assert.assertEquals("00:10", string);
    }


    public void testLong_2_YYYYMMDD_HHmm() {
        long l = System.currentTimeMillis();
        SimpleDateFormat fat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String string1 = fat.format(new Date(l));
        String string2 = util.long_2_YYYYMMDD_HHmm(l);
        Assert.assertEquals(string1, string2);
    }

    public void testLong_2_DayOfTheWeek1() {
        long l = System.currentTimeMillis();
        String string2 = util.long_2_DayOfTheWeek(l);
        Assert.assertEquals("周二", string2);
    }

    public void testLong_2_DayOfTheWeek2() {
        long l = System.currentTimeMillis() + 3600*24*1000;
        String string2 = util.long_2_DayOfTheWeek(l);
        Assert.assertEquals("周三", string2);
    }
}
