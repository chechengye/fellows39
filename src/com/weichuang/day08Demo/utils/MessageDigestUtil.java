package com.weichuang.day08Demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * MD5加密工具类
 * @author cc
 */
public class MessageDigestUtil {

    public static String getMessageDigestStr(String s){
        String encode = null;
        try {
            //pmq7VoTEWWLYh1ZPCDRujQ==
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //Base64 : a-z A-Z 0-9 + /
            // == ： MD5加密后的结束符标记
            encode = Base64.getEncoder().encodeToString(md5.digest(s.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encode;
    }
}
