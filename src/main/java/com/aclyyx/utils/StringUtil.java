package com.aclyyx.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 工具类,字符串工具
 * 版本:v0.1
 * Created by aclyyx on 16/5/16.
 */
public class StringUtil {

    private static StringUtil util;

    private StringUtil() {
    }

    /**
     * 获取工具单例对象
     * @return
     */
    public static StringUtil newInstance() {
        if (util == null) {
            util = new StringUtil();
        }
        return util;
    }

    /**
     * 对传入字符串进行MD5编码并返回
     * @param string 待编码字符串
     * @return MD5
     */
    public String MD5(String string) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }

    /**
     *对传入字符串进行SHA1编码并返回
     * @param string 待编码字符串
     * @return SHA1
     */
    public String SHA1(String string) {

        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(string.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
