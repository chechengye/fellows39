package com.weichuang.day07Demo;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 程序国际化操作
 * Internationalization : i18n
 *
 */
public class InternationalizationDemo {

    public static void main(String[] args) {
        //通常会帮我获取语言环境，可根据参数设定语言环境
        //参数： 语言代码 , 国家或地区
        Locale localeZH = new Locale("zh" , "CN");
        Locale localeEN = new Locale("en" , "US");
        //获取系统默认的语言环境
        Locale localDefault = Locale.getDefault();
        //获取资源文件的
        //getBundle: 第一个参数是文件的基本名(前缀 : 比如info)
        ResourceBundle rb = ResourceBundle.getBundle("com.weichuang.day07Demo.info" , localeEN);
        System.out.println(rb.getString("system.name"));
        System.out.println(rb.getString("login.username"));
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        System.out.println(rb.getString("login.password"));
        String password = sc.next();
        if("admin".equals(username) && "1234".equals(password)){
            System.out.println(rb.getString("login.success"));
        }
    }
}
