package com.weichuang.day08Demo;

import java.text.DecimalFormat;

/**
 * 数字处理工具类
 * 推荐使用 #号作为摸版
 */
public class DecimalFormatDemo {
    public static void main(String[] args) {
        double pi = 3.1415926;
        System.out.println("--------取两位小数--------");
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(pi));
        System.out.println("--------取四位小数--------");
        System.out.println(new DecimalFormat("0.0000").format(pi));
    }
}
