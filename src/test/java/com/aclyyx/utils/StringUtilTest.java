package com.aclyyx.utils;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by aclyyx on 16/5/17.
 */
public class StringUtilTest extends TestCase {

    private StringUtil util;

    @Override
    protected void setUp() throws Exception {
        util = StringUtil.newInstance();
    }

    public void testMD5() {
        String string1 = util.MD5("123456");
        Assert.assertEquals("e10adc3949ba59abbe56e057f20f883e", string1);
    }

    public void testSHA1() {
        String string1 = util.SHA1("123456");
        Assert.assertEquals("7c4a8d09ca3762af61e59520943dc26494f8941b", string1);
    }
}
