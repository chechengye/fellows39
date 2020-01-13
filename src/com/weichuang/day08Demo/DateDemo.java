package com.weichuang.day08Demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期类
 */
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        //日历对象的两种创建方式 1
        Calendar c1 = Calendar.getInstance();
        //2 多态子类的方式
        Calendar c2 = new GregorianCalendar();

        System.out.println();//
        System.out.println("当前系统时间:");
        StringBuilder sb = new StringBuilder();
        sb.append(c1.get(Calendar.YEAR))
                .append("年")
                .append(c1.get(2) + 1)
                .append("月")
                .append(c1.get(Calendar.DAY_OF_MONTH))
                .append("日 ")
                .append(c1.get(Calendar.HOUR))
                .append(":")
                .append(c1.get(Calendar.MINUTE))
                .append(":")
                .append(c1.get(Calendar.SECOND));
        System.out.println(sb);
        /*DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(df.format(date));*/
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date));
    }
}
