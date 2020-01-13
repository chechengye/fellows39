package com.weichuang.day08Demo;

import com.weichuang.day08Demo.utils.MessageDigestUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

/**
 * MD5加密解密算法
 * Base64 1.8才支持，仅支持加密操作，并不支持反解密操作
 * BASE64Encoder 1.8以前使用的， 同时支持加密解密
 */
public class MessageDigestDemo {

    public static void main(String[] args) {
        try {
            //pmq7VoTEWWLYh1ZPCDRujQ==
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String pwd = "admin123456";
            System.out.println(Arrays.toString(pwd.getBytes()));

            System.out.println("------------经过MD5计算过的------------");
            System.out.println(Arrays.toString(md5.digest(pwd.getBytes())));
            //Base64 : a-z A-Z 0-9 + /
            // == ： MD5加密后的结束符标记
            String encode = Base64.getEncoder().encodeToString(md5.digest(pwd.getBytes()));
            System.out.println(encode);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String str = MessageDigestUtil.getMessageDigestStr("dshdhsgdhsgdhsgh000");
        System.out.println(str);

        String savePwd = "pmq7VoTEWWLYh1ZPCDRujQ==";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入密码:");
        String pwd = sc.next();
        System.out.println(login(savePwd, pwd));
    }

    public static String login(String savePwd , String pwd){
        if(savePwd.equals(MessageDigestUtil.getMessageDigestStr(pwd))){
            return "密码正确";
        }else{
            return "密码错误";
        }
    }
}
